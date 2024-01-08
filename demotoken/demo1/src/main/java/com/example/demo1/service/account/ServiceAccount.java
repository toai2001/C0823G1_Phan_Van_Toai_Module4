package com.example.demo1.service.account;

import com.example.demo1.Model.Account;
import com.example.demo1.repository.account.AccountRepository;
import com.example.demo1.repository.account.IAccountRepository;

import java.util.List;

public class ServiceAccount implements IServiceAccount {
    private   IAccountRepository  accountRepository= new AccountRepository();
    @Override
    public Account findById(int idAccount) {
        return accountRepository.findById(idAccount);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public boolean createAccount(Account account) {
        return accountRepository.createAccount(account);
    }

    @Override
    public Account findByName(String account) {
        return accountRepository.findByName(account);
    }

    @Override
    public Account findAccount(String useName, String password) {
        return accountRepository.findAccount(useName, password);
    }

    @Override
    public int findIdAccount(String account) {
        return accountRepository.findIdAccount(account);
    }




}
