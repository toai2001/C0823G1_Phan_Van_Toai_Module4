package com.example.demo1.repository.account;

import com.example.demo1.Model.Account;

import java.util.List;

public interface IAccountRepository {
    Account findById(int idAccount);
    List<Account> findAll();
    boolean createAccount(Account account);
    Account findByName (String account);
    Account findAccount(String useName, String password);
    int findIdAccount(String account);

}