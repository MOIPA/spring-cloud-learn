package com.example.userservice.service;

import com.example.userservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
