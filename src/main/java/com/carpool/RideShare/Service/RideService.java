package com.carpool.RideShare.Service;

import com.carpool.RideShare.Model.Ride;
import com.carpool.RideShare.Repository.RideRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private static final Logger logger = LoggerFactory.getLogger(RideService.class);

    @Autowired
    private RideRepository rideRepository;

    /**
     * Handles the ride request and saves it to the database.
     *
     * @param rideRequest The ride request details.
     * @return The saved ride object.
     * @throws IllegalArgumentException If the ride request is invalid.
     */
    public Ride requestRide(Ride rideRequest) {
        // Log the ride request
        logger.info("Processing ride request: {}", rideRequest);

        // Validate the ride request
        if (rideRequest.getPickupLocation() == null || rideRequest.getDropLocation() == null) {
            logger.error("Invalid ride request: Missing required fields");
            throw new IllegalArgumentException("Invalid ride request: Missing required fields");
        }

        // Set default status and fare if not provided
        if (rideRequest.getStatus() == null) {
            rideRequest.setStatus("Requested");
        }
        if (rideRequest.getFare() <= 0) {
            rideRequest.setFare(10.0); // Default fare
        }

        // Save the ride request to MongoDB
        Ride savedRide = rideRepository.save(rideRequest);
        logger.info("Ride request saved: {}", savedRide);

        return savedRide;
    }

    public Ride acceptRide(Integer id) {
        Ride ride = rideRepository.getRidesById(id);
        logger.info("Accepting ride request: {}", ride);
        if (ride.getStatus().equals("Requested")) {
            ride.setStatus("Accepted");
        }
        Ride acceptedRide = rideRepository.save(ride);
        logger.info("Ride request accepted: {}", acceptedRide);

        return acceptedRide;
    }

    public List<Ride> getRides() {
        return rideRepository.findAll();
    }
}