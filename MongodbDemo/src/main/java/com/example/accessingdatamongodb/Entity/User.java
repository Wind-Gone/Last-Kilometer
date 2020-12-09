package com.example.accessingdatamongodb.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="User")
public class User {

    @Id
    private String id;

    private String name;

    private double balance;

    private double creditScore;

    public User(){};

    public User(String name, double balance, double creditScore) {
        this.name = name;
        this.balance = balance;
        this.creditScore = creditScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", creditScore=" + creditScore +
                '}';
    }
}