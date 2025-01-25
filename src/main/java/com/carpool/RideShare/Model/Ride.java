package com.carpool.RideShare.Model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ride")
public class Ride {
    // id, pickupLocation, dropLocation, driverId,
    //riderId, status (e.g., Requested, Ongoing, Completed), and fare.
    @Id
    protected int id;
    protected String pickupLocation;
    protected String dropLocation;
    protected int driverId;
    protected int riderId;
    protected String status;
    protected double fare;

    public Ride() {
    }

    public Ride(int id, String pickupLocation, String dropLocation, int driverId, int riderId, String status, double fare) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.driverId = driverId;
        this.riderId = riderId;
        this.status = status;
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                ", driverId=" + driverId +
                ", riderId=" + riderId +
                ", status='" + status + '\'' +
                ", fare=" + fare +
                '}';
    }
}
