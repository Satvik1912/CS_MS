package com.cars24.dao;

import com.cars24.data.Entities.Req.AddCustomerReq;
import com.cars24.data.Entities.Req.CustomerProfileReq;
import com.cars24.data.Entities.response.CustomerProfileResponse;

// make only the CustomerDao interface public, and remove the public modifier from the others.
// Public interface for Customer operations
public interface CustomerDao {
   String createCustomer(int customer_id,String name, String phone, String email, String address);

   String createCustomerv2(AddCustomerReq addCustomerReq);
//   void updateCustomer(int customerId, String name, String phone, String email, String address);
//   void deleteCustomer(int customerId);
//   void readCustomer(int customerId);
//   void readAllCustomers();
public   CustomerProfileResponse getCustomerProfile(CustomerProfileReq customerProfileReq);
}




