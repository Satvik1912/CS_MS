package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.Entities.Req.AddCustomerReq;
import com.cars24.data.Entities.Req.CustomerProfileReq;
import com.cars24.data.Entities.response.CustomerProfileResponse;
import com.cars24.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    private static final String INSERT_SUCCESS_MESSAGE = "Customer inserted successfully.";
    private static final String INSERT_ERROR_MESSAGE = "Error while adding customer.";

    @Override
    public String createCustomer(int id, String name, String phone, String email, String address) {
        String insertSQL = "INSERT INTO customers (customer_id, name, phone, email, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DbUtil.getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters for the prepared statement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, address);

            // Execute the update
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Row inserted successfully. Rows affected: " + rowsInserted);
            return INSERT_SUCCESS_MESSAGE;

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage() + ", SQL State: " + e.getSQLState() + ", Error Code: " + e.getErrorCode());
            return INSERT_ERROR_MESSAGE;
        }
    }

    @Override
    public String createCustomerv2(AddCustomerReq addCustomerReq) {
        String insertSQL = "INSERT INTO customers (customer_id, name, phone, email, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DbUtil.getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setInt(1, 0); // Replace with the actual ID if necessary
            preparedStatement.setString(2, addCustomerReq.getName());
            preparedStatement.setString(3, addCustomerReq.getPhone());
            preparedStatement.setString(4, addCustomerReq.getEmail());
            preparedStatement.setString(5, addCustomerReq.getAddress());

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Row inserted successfully. Rows affected: " + rowsInserted);
            return INSERT_SUCCESS_MESSAGE;

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage() + ", SQL State: " + e.getSQLState() + ", Error Code: " + e.getErrorCode());
            return INSERT_ERROR_MESSAGE;
        }
    }


    public CustomerProfileResponse getCustomerProfile(CustomerProfileReq customerProfileReq) {
        String selectSQL = "SELECT name, email, phone, address FROM customers WHERE email=? OR phone = ?";
        try (Connection connection = DbUtil.getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, customerProfileReq.getEmail());
            preparedStatement.setString(2, customerProfileReq.getPhone());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                // Populate and return the response object
                CustomerProfileResponse response = new CustomerProfileResponse();
                response.setName(name);
                response.setEmail(email);
                response.setPhone(phone);
                response.setAddress(address);
                return response;
            } else {
                System.out.println("No customer found with email: " + customerProfileReq.getEmail());
                return new CustomerProfileResponse(); // Return an empty response instead of null
            }
        } catch (SQLException e) {
            System.err.println("SQL Error while fetching customer profile: " + e.getMessage());
            return null; // Or return an empty response here as well if needed
        }
    }
}
