package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.User;
import com.studysingh.AlumniApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public int updateUser(User user) {
        return userRepository.update(user);
    }

    public int deleteUser(int userId) {
        return userRepository.deleteById(userId);
    }

    public int getUserByEmail(User user) {
        return  userRepository.getUserByEmail(user);
    }

    public int verifyUser(User user) {
        return userRepository.verifyUser(user);
    }
}
