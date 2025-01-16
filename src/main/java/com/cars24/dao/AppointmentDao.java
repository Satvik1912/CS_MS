package com.cars24.dao;

public interface AppointmentDao {
    void createAppointment(int customerId, int vehicleId, int serviceId, String appointmentDate, String status);
    void updateAppointment(int appointmentId, String status);
    void deleteAppointment(int appointmentId);
    void readAppointment(int appointmentId);
    void readAllAppointments();
}
