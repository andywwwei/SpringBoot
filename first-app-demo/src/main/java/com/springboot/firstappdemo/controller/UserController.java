package com.springboot.firstappdemo.controller;

import com.springboot.firstappdemo.domain.User;
import com.springboot.firstappdemo.repository.UserRepository;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)){
            System.out.printf("用户对象: %s 保存成功! \n",user);
        }
        return user;
    }

//    @GetMapping("/person/findAll")
//    public Collection<User> findAll() {
//        return userRepository.findAll();
//    }

}
