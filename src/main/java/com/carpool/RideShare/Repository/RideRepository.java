package com.carpool.RideShare.Repository;

import com.carpool.RideShare.Model.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends MongoRepository<Ride, String> {

    Ride getRidesById(Integer id);
}
