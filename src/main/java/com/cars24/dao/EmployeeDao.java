package com.cars24.dao;

public interface EmployeeDao {
    void createEmployee(String name, String phone, String email, String role, double salary);
    void updateEmployee(int employeeId, String name, String phone, String email, String role, double salary);
    void deleteEmployee(int employeeId);
    void readEmployee(int employeeId);
    void readAllEmployees();
}
