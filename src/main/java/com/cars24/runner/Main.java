package com.cars24.runner;
import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.Entities.Req.AddCustomerReq;
import com.cars24.data.Entities.Req.CustomerProfileReq;
import com.cars24.data.Entities.response.CustomerProfileResponse;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       boolean exit=true;

       while(exit)
       {
           System.out.println("Enter your choice:");
           System.out.println("1. Add Customer");
           System.out.println("2. GET Customer");
           System.out.println("0. TO EXIT");
           int choice=scanner.nextInt();
           switch (choice)
           {
               case 1:Ui.addCustomer();
               break;
               case 2:Ui.getCustomer();
               break;
               default:exit=false;
           }
       }
    }
}
