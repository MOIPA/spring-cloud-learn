package com.example.userservice.service;

import com.example.userservice.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList;

    @Override
    public void create(User user) {
        userList.add(user);
    }

    @Override
    public User getUser(Long id) {
        List<User> user = userList.stream().filter((x) -> x.getId().equals(id)).collect(Collectors.toList());
        if (user.size() > 0) return user.get(0);
        return null;
    }

    @Override
    public void update(User user) {
        userList.stream().filter(x -> x.getId().equals(user.getId())).forEach(x -> {
            x.setPassword(user.getPassword());
            x.setUsername(user.getUsername());
        });
    }

    @Override
    public void delete(Long id) {
        User user = getUser(id);
        if (user != null) {
            userList.remove(user);
        }
    }

    @Override
    public User getByUsername(String username) {
        List<User> list = userList.stream().filter(x -> x.getUsername().equals(username)).collect(Collectors.toList());
        if (list.size() > 0) return list.get(0);
        return null;
    }

    @Override
    public List<User> getUserByIds(List<Long> ids) {
        return userList.stream().filter(x -> ids.contains(x.getId())).collect(Collectors.toList());
    }

    @PostConstruct
    public void initData() {
        userList = new ArrayList<>();
        userList.add(new User(1l, "tr", "123"));
        userList.add(new User(2l, "tzq", "123"));
        userList.add(new User(3l, "ss", "123"));
    }
}
