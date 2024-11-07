package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.User;
import com.studysingh.AlumniApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") int userId, @RequestBody User user) {
        user.setUserId(userId);
        userService.updateUser(user);
        return "User updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
        return "User deleted successfully";
    }

    @PostMapping("/getId")
    public int getUserByEmail(@RequestBody User user) {
        return userService.getUserByEmail(user);
    }

    @PostMapping("/verify")
    public int verifyUser(@RequestBody User user) {
        return userService.verifyUser(user);
    }
}
