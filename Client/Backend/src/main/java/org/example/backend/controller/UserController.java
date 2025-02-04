package org.example.backend.controller;

import org.example.backend.model.Users;
import org.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ruscordRegistration")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Метод для сохранения пользователя в БД
    @PostMapping()
    public Users createUser(@RequestBody Users user) {
        System.out.println("Получен пользователь: " + user);
        try {
            System.out.println("Сохранен пользователь: " + user);
            return userRepository.save(user);
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении пользователя: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

}
