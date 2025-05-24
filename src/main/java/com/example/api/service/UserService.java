package com.example.api.service;
import com.example.api.model.Permission;
import com.example.api.model.SchoolClass;

import com.example.api.dto.LoginUser;
import com.example.api.dto.RegisterUser;
import com.example.api.model.Student;
import com.example.api.model.User;
import com.example.api.repository.ClassRepository;
import com.example.api.repository.PermissionRepository;
import com.example.api.repository.StudentRepository;
import com.example.api.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;

    public UserService(UserRepository userRepository,
                       PermissionRepository permissionRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       ClassRepository classRepository,
                       StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public User signUp(RegisterUser input){
        if (userExists(input.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User();
        user.setEmail(input.getEmail());
        user.setFullName(input.getFullName());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setPhone(input.getPhone());

        Permission permission = assignRoleToPermission(input.getRole());
        user.getPermissions().add(permission);

        if ("teacher".equalsIgnoreCase(input.getRole())) {
            if (input.getClassIds() == null || input.getClassIds().isEmpty()) {
                throw new IllegalArgumentException("Teacher must be assigned at least one class");
            }
            List<SchoolClass> classes = classRepository.findAllById(input.getClassIds());
            if (classes.size() != input.getClassIds().size()) {
                throw new IllegalArgumentException("Some classes not found");
            }
            user.setClasses(classes);
        }

        if ("parent".equalsIgnoreCase(input.getRole())) {
            if (input.getStudentIds() == null || input.getStudentIds().isEmpty()) {
                throw new IllegalArgumentException("Parent must be assigned at least one student");
            }
            List<Student> children = studentRepository.findAllById(input.getStudentIds());
            if (children.size() != input.getStudentIds().size()) {
                throw new IllegalArgumentException("Some students not found");
            }
            user.setChildren(children);
        }

        return userRepository.save(user);
    }

    private Permission assignRoleToPermission(String role) {
        Permission permission;
        switch (role.toLowerCase()) {
            case "admin":
                permission = permissionRepository.findByPermission("ROLE_ADMIN");
                if (permission == null) {
                    permission = new Permission();
                    permission.setPermission("ROLE_ADMIN");
                    permission.setName("Admin Role");
                    permission = permissionRepository.save(permission);
                }
                break;
            case "teacher":
                permission = permissionRepository.findByPermission("ROLE_TEACHER");
                if (permission == null) {
                    permission = new Permission();
                    permission.setPermission("ROLE_TEACHER");
                    permission.setName("Teacher Role");
                    permission = permissionRepository.save(permission);
                }
                break;
            case "parent":
                permission = permissionRepository.findByPermission("ROLE_PARENT");
                if (permission == null) {
                    permission = new Permission();
                    permission.setPermission("ROLE_PARENT");
                    permission.setName("Parent Role");
                    permission = permissionRepository.save(permission);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
        return permission;
    }

    public User authenticate(LoginUser input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(), input.getPassword()
                )
        );

        User user = userRepository.findByEmail(input.getEmail());
        if(user == null) {
            throw new UsernameNotFoundException("Email or password is not correct");
        }

        return user;
    }

    public boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
