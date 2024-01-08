package com.example.demo1.repository.account;

import com.example.demo1.Model.Account;
import com.example.demo1.repository.baseRepository.BaseRepository;
import com.example.demo1.service.utils.BCryptUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    private static final String SELECT_BY_ID = "select * from tai_khoan where id_tai_khoan = ?";
    private static final String SELECT_ALL = "select * from tai_khoan";
    private static final String NEW_EMPLOYEE = "insert into tai_khoan(tai_khoan, mat_khau, loai_tai_khoan) " +
            "values(?,?,?);";
    private static final String SELECT_BY_USERNAME = "SELECT * FROM tai_khoan WHERE tai_khoan = ?";
    private static final String SELECT_BY_USERNAME_AND_PASSWORD = "SELECT * FROM tai_khoan WHERE tai_khoan = ? AND mat_khau = ?";
    private static final String SELECT_ID_ACCOUNT = "select tai_khoan.id_tai_khoan\n" +
            "from tai_khoan\n" +
            "where tai_khoan.tai_khoan = ?;";
    @Override
    public Account findById(int idAccount) {
        Connection connection = BaseRepository.getConnection();
        Account account = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, idAccount);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id_tai_khoan");
                String account1 = resultSet.getString("tai_khoan");
                String password = resultSet.getString("mat_khau");

                String typeAccount = resultSet.getString("loai_tai_khoan");
                account = new Account(id, account1, password, typeAccount);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return account;
    }

    @Override
    public List<Account> findAll() {
        Connection connection = BaseRepository.getConnection();
        Account account = null;
        List<Account> accountList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_tai_khoan");
                String useName = resultSet.getString("tai_khoan");
                String pass = resultSet.getString("mat_khau");
                String type = resultSet.getString("loai_tai_khoan");
                account = new Account(id, useName, pass, type);
                accountList.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accountList;
    }

    @Override
    public boolean createAccount(Account account) {
        Connection connection = BaseRepository.getConnection();
        int count = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(NEW_EMPLOYEE);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getAccountType());
            count=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (count == 1);

    }

    @Override
    public Account findByName(String account) {
        Connection connection= BaseRepository.getConnection();
        Account account1= null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_BY_USERNAME);
            preparedStatement.setString(1,account);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()){
                int account_id = resultSet.getInt("id_tai_khoan");
                String name = resultSet.getString("tai_khoan");
                String pass = resultSet.getString("mat_khau");
                String type = resultSet.getString("loai_tai_khoan");
                account1= new Account(account_id,name,pass,type);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account1;
    }

    @Override
    public Account findAccount(String useName, String password) {
        Connection connection= BaseRepository.getConnection();
        Account account= null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1,useName);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int account_id = resultSet.getInt("id_tai_khoan");
                String name = resultSet.getString("tai_khoan");
                String pass = resultSet.getString("mat_khau");
                String type = resultSet.getString("loai_tai_khoan");
                account= new Account(account_id,name,pass,type);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public int findIdAccount(String account) {
        int idAccount= 0 ;
        Connection connection= BaseRepository.getConnection();

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ID_ACCOUNT);
            preparedStatement.setString(1,account);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                idAccount=resultSet.getInt("id_tai_khoan");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return idAccount;
    }
}
