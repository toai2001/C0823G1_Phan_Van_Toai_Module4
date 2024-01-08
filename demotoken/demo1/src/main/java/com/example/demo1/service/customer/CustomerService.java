package com.example.demo1.service.customer;

import com.example.demo1.Model.Customer;
import com.example.demo1.repository.customer.CustomerRepository;
import com.example.demo1.repository.customer.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private final ICustomerRepository customerRepository= new CustomerRepository();

    @Override
    public List<Customer> display() {
        return customerRepository.display();
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public Customer checkIdCustomer(int checkIdCustomer) {
        return customerRepository.checkIdCustomer(checkIdCustomer);
    }
}
