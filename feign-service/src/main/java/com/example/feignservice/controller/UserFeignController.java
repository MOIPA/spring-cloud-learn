package com.example.feignservice.controller;

import com.example.feignservice.domain.CommonResult;
import com.example.feignservice.domain.User;
import com.example.feignservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    CommonResult create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/{id}")
    CommonResult<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    CommonResult<User> getByUsername(@RequestParam String username){
        return userService.getByUsername(username);
    }

    @PostMapping("/update")
    CommonResult update(@RequestBody User user){
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    CommonResult delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
