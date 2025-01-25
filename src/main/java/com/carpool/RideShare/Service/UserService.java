package com.carpool.RideShare.Service;

import com.carpool.RideShare.Exception.RideShareException;
import com.carpool.RideShare.Model.User;
import com.carpool.RideShare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean addUser(User user) {
        String email= user.getEmail();
        String password = user.getPassword();
        String role = user.getRole();
        if(!email.endsWith("@gmail.com") )
        {
            throw new RideShareException("Invalid email address");
        }
        if(password.length()<6)
        {
            throw new RideShareException("Password must be at least 6 characters");
        }
        if(!(role.equalsIgnoreCase("Driver") || role.equalsIgnoreCase("Rider")))
        {
            throw new RideShareException("Invalid role");
        }
        if(userRepository.findByEmail(user.getEmail()) != null)
        {
            throw new RideShareException("User already exist with the email " + user.getEmail());
        }
        userRepository.save(user);
        return true;
    }
    public User getUserById(int id) {
        if(userRepository.findById(id) == null)
        {
            throw new RideShareException("No user found with the id " + id);
        }
       return userRepository.findById(id);
    }
}
