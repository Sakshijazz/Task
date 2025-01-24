package com.carpool.RideShare.Repository;

import com.carpool.RideShare.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);

    User findById(int id);
}
