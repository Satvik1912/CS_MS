package com.cars24.services;

import com.cars24.data.Entities.Req.AddCustomerReq;
import com.cars24.data.Entities.Req.CustomerProfileReq;
import com.cars24.data.Entities.response.CustomerProfileResponse;

public interface CustomerServices {
    public String registerCustomer(AddCustomerReq addCustomerReq);
    public CustomerProfileResponse getCustomerProfile(CustomerProfileReq customerProfileReq);
}
