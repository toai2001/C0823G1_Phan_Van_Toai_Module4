package com.example.demo1.service.account;

import com.example.demo1.Model.Account;

import java.util.List;

public interface IServiceAccount {
    Account findById(int idAccount);
    List<Account> findAll();
    boolean createAccount(Account account);
    Account findByName (String account);
    Account findAccount(String useName, String password);
    int findIdAccount(String account);
}
