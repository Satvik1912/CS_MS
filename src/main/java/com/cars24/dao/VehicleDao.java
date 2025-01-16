package com.cars24.dao;

public interface VehicleDao {
    void createVehicle(int customerId, String licensePlate, String model, String make, int year, String color);
    void updateVehicle(int vehicleId, String licensePlate, String model, String make, int year, String color);
    void deleteVehicle(int vehicleId);
    void readVehicle(int vehicleId);
    void readAllVehicles();
}
