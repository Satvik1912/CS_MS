package com.cars24.dao;

public interface ServiceDao {
    void createService(String serviceName, double price);
    void updateService(int serviceId, String serviceName, double price);
    void deleteService(int serviceId);
    void readService(int serviceId);
    void readAllServices();
}
