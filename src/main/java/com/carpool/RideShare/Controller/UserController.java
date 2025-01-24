package com.carpool.RideShare.Controller;

import com.carpool.RideShare.Model.User;
import com.carpool.RideShare.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management", description = "APIs for user-related operations")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Create a new user",
            description = "Registers a new user in the system")
    public boolean register(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID",
            description = "Retrieves detailed user information")
    public User getUser( @PathVariable int id) {
        return userService.getUserById(id);
    }
}
