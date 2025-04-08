    package com.example.api.controller;

    import com.example.api.model.User;
    import com.example.api.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @CrossOrigin(origins = "http://localhost:8080")
    @RestController
    @RequestMapping("/users")
    public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping
        public ResponseEntity<List<User>> getAllUsers() {
            return ResponseEntity.ok(userService.getAllUsers());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
            return ResponseEntity.ok(userService.getUserById(id));
        }

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            return ResponseEntity.ok(userService.saveUser(user));
        }

        @PostMapping("/login")
        public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
            Optional<User> user = userService.getUserByEmail(loginRequest.getEmail());

            if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok(user.get()); // Trả về thông tin user nếu đăng nhập thành công
            } else {
                return ResponseEntity.status(401).body("Invalid email or password");
            }
        }
    }
