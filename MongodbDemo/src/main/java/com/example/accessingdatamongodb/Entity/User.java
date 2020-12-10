package com.example.accessingdatamongodb.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="User")
public class User {

    @Id
    private String id;

    /* 学号 */
    private String studentID;

    /* 真实姓名 */
    private String name;

    /* 余额 */
    private double balance;

    /* avatar_url */
    private String avatar_url;

    /* openid */
    private String open_id;

    private double creditScore;

    private Tag tag;

    public User(){};

    public User(String studentID, String name, double balance, String avatar_url, String open_id, double creditScore, Tag tag) {
        this.studentID = studentID;
        this.name = name;
        this.balance = balance;
        this.avatar_url = avatar_url;
        this.open_id = open_id;
        this.creditScore = creditScore;
        this.tag = tag;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
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