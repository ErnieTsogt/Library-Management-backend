package com.LibraryManagement.Projekt.Controller;

import com.LibraryManagement.Projekt.Model.User;
import com.LibraryManagement.Projekt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.logout(); // Wylogowanie użytkownika
        } catch (Exception e) {
            throw new RuntimeException("Logout failed");
        }
    }
}


