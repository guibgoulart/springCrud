package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    @Qualifier("noValidationUserService")
    UserService service;

    @GetMapping("/{id}")
    public User findById(@PathVariable @Positive Integer id) {
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    public User findByUsername(@PathVariable @NotEmpty String name) {
        return service.findByName(name);
    }

    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return service.create(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable @Positive Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody @Valid User user, @PathVariable @Positive Integer id) {
        return service.updateUser(user, id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.findAll();
    }
}
