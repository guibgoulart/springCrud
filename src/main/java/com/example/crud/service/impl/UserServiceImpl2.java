package com.example.crud.service.impl;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("noValidationUserService")
public class UserServiceImpl2 implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public User findByName(String name) {
        return repository.findByUsername(name).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public User updateUser(User user, Integer id) {
        user.setId(id);
        return repository.save(user);
    }
}
