package com.example.demo1.repository.customer;

import com.example.demo1.Model.Account;
import com.example.demo1.Model.Customer;
import com.example.demo1.repository.account.AccountRepository;
import com.example.demo1.repository.account.IAccountRepository;
import com.example.demo1.repository.baseRepository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final IAccountRepository accountRepository = new AccountRepository();
    private static final String DELETE = "delete from khach_hang where id_khach_hang = ?";
    private static final String SELECT_ALL = "select id_khach_hang,ho_ten,so_dien_thoai,dia_chi,gmail from khach_hang;";
    private static final String INSERT = "INSERT INTO khach_hang(ho_ten,so_dien_thoai,dia_chi,gmail,id_loai_khach,id_tai_khoan) VALUES (?,?,?,?,1,?);";
    private static final String SELECT_BY_ID = "select id_khach_hang,ho_ten,so_dien_thoai,dia_chi,gmail from khach_hang where id_khach_hang = ?";


    @Override
    public List<Customer> display() {
        Connection connection = BaseRepository.getConnection();

        List<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_khach_hang");
                String name = resultSet.getString("ho_ten");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String address = resultSet.getString("dia_chi");
                String gmail = resultSet.getString("gmail");
                Account account = accountRepository.findById(resultSet.getInt("id_tai_khoan"));
                customerList.add(new Customer(id, name, phoneNumber, address, gmail, account));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;

    }

    @Override
    public void add(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhoneNumber());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setInt(5, customer.getIdAccount().getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Customer customer) {
    }

    @Override
    public Customer checkIdCustomer(int checkIdCustomer) {
        Connection connection= BaseRepository.getConnection();
        Customer customer= null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,checkIdCustomer);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("id_khach_hang");
                String name = resultSet.getString("ho_ten");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String address = resultSet.getString("dia_chi");
                String gmail = resultSet.getString("gmail");
                Account account = accountRepository.findById(resultSet.getInt("id_tai_khoan"));
                customer= new Customer(id,name,phoneNumber,address,gmail,account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;


    }
}
