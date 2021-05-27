package com.example.crud.service;

import com.example.crud.entity.User;

import java.util.List;

public interface UserService {
    public User create(User user);
    public List<User> findAll();
    public User findById(Integer id);
    public User findByName(String name);
    public void deleteById(Integer id);
    public User updateUser(User user, Integer id);
}
