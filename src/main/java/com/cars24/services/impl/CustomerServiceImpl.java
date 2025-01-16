package com.cars24.services.impl;

import com.cars24.CustomerValidity;
import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.Entities.Req.AddCustomerReq;
import com.cars24.data.Entities.Req.CustomerProfileReq;
import com.cars24.data.Entities.response.CustomerProfileResponse;
import com.cars24.services.CustomerServices;

public class CustomerServiceImpl implements CustomerServices {
    private CustomerDaoImpl customerDao=new CustomerDaoImpl();
    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {
        try {
            CustomerValidity.validateAddCustomerRequest(addCustomerReq);
            customerDao.createCustomerv2(addCustomerReq);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public CustomerProfileResponse getCustomerProfile(CustomerProfileReq customerProfileReq) {

        return null;
    }
}
