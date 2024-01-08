package com.example.demo1.repository.customer;

import com.example.demo1.Model.Customer;

import java.util.List;

 public interface  ICustomerRepository {
    List<Customer> display();
    void add (Customer customer);
    void remove(int id);
    void update(Customer customer);

    Customer checkIdCustomer(int checkIdCustomer);
}
