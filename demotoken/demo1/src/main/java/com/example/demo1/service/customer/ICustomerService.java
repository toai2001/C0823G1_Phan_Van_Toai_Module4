package com.example.demo1.service.customer;

import com.example.demo1.Model.Account;
import com.example.demo1.Model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> display();
    void add (Customer customer);
    void remove(int id);
    void update(Customer customer);

    Customer checkIdCustomer(int checkIdCustomer);
}
