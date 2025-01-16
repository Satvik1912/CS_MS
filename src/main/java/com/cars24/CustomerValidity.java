package com.cars24;

import com.cars24.data.Entities.Req.AddCustomerReq;

public class CustomerValidity {
    public static void validateAddCustomerRequest(AddCustomerReq addCustomerReq) {
        validateAddCustomerName(addCustomerReq.getName());
    }
    private static void validateAddCustomerName(String name) {
        if(name == null)
        {
            throw new IllegalArgumentException("name cannot be null");
            // Exceptions are written to stop the execution then and there
        }
        if(name.length()<3 || name.length()<=100) {
            throw new IllegalArgumentException("name length must be between 3 and 100");
        }
    }
    public void validateAddCustomerPhone(String phone) {
        if(phone == null)
            return;
        else if(phone.length()!=10)
            return;
    }

}
