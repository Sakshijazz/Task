package com.carpool.RideShare.Controller;

import com.carpool.RideShare.Model.User;
import com.carpool.RideShare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);

    }
}
