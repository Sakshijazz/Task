package com.carpool.RideShare.Controller;

import com.carpool.RideShare.Model.Ride;
import com.carpool.RideShare.Service.RideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rides")
public class RideController {

    @Autowired
    private RideService rideService;
    private static final Logger logger = LoggerFactory.getLogger(RideController.class);

    @GetMapping
    public ResponseEntity<List<Ride>> getRides() {
        logger.info("Getting all rides");
        List<Ride> rides= rideService.getRides();
        return new ResponseEntity<>(rides, HttpStatus.OK);
    }

    @PostMapping("/request")
    public ResponseEntity<Ride> requestRide(@RequestBody Ride rideRequest) {
        // Log the ride request
        logger.info("Ride request received: {}", rideRequest);

        try {
            // Delegate the ride request to the service
            Ride savedRide = rideService.requestRide(rideRequest);
            return ResponseEntity.ok(savedRide);
        } catch (IllegalArgumentException e) {
            // Handle validation errors
            logger.error("Invalid ride request: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            // Handle unexpected errors
            logger.error("Error processing ride request: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<Ride> acceptRide(@PathVariable Integer id) {
        Ride acceptedRide = rideService.acceptRide(id);
        return new ResponseEntity<>(acceptedRide, HttpStatus.OK);
    }

}
