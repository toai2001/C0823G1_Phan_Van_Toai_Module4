package com.example.demo1.Model;

public class Account {
    private int idAccount;
    private String username;
    private String password;
    private String accountType;
    public Account(int idAccount) {
        this.idAccount = idAccount;
    }

    public Account(int idAccount, String username, String password, String accountType) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }
    public Account( String username, String password, String accountType) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
