    package com.example.api.controller;

    import com.example.api.dto.LoginResponse;
    import com.example.api.dto.LoginUser;
    import com.example.api.dto.RegisterUser;
    import com.example.api.model.User;
    import com.example.api.service.JwtService;
    import com.example.api.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;
    import java.util.stream.Collectors;

    @CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("/users")
    public class UserController {
        private final UserService userService;
        private final JwtService jwtService;

        public UserController(UserService userService, JwtService jwtService) {
            this.userService = userService;
            this.jwtService = jwtService;
        }

        @GetMapping()
        public ResponseEntity<?> getAllUsers() {
            try {
                List<User> users = userService.getAllUsers();
                return ResponseEntity.ok(users);
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Error fetching users: " + e.getMessage());
            }
        }

        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody RegisterUser req) {
            try {
                if (userService.userExists(req.getEmail())) {
                    return ResponseEntity.badRequest().body("Email already in use.");
                }
                User user = userService.signUp(req);
                return ResponseEntity.status(201).body(user);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500).body("An error occurred while registering user: " + e.getMessage());
            }
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginUser req) {
            try {
                User user = userService.authenticate(req);

                List<String> roles = user.getPermissions().stream()
                        .map(p -> p.getPermission())
                        .collect(Collectors.toList());

                if (roles.isEmpty()) {
                    return ResponseEntity.status(403).body("No permissions assigned to this user.");
                }

                String jwtToken = jwtService.generateToken(user);

                LoginResponse rs = new LoginResponse();
                rs.setToken(jwtToken);
                rs.setRoles(roles);

                return ResponseEntity.ok(rs);
            } catch (Exception e) {
                return ResponseEntity.status(401).body("Invalid credentials: " + e.getMessage());
            }
        }
    }