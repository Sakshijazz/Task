package com.carpool.RideShare.Service;

import com.carpool.RideShare.Model.User;
import com.carpool.RideShare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean addUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null)
        {
            return false;
        }
        userRepository.save(user);
        return true;
    }
    public User getUserById(int id) {
        if(userRepository.findById(id) != null)
        {
            return userRepository.findById(id);
        }
        return null;

    }
}
