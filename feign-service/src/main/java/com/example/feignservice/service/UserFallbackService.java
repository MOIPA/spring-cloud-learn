package com.example.feignservice.service;

import com.example.feignservice.domain.CommonResult;
import com.example.feignservice.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserService{
    @Override
    public CommonResult create(User user) {
        return new CommonResult(new User(-1L, "default", "def"));
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        return new CommonResult(new User(-1L, "default", "def"));
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        return new CommonResult(new User(-1L, "default", "def"));
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult(null,"failed service degraded",500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult(null,"failed service degraded",500);
    }
}
