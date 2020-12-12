package com.example.accessingdatamongodb.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ApiModel(value = "用户实体类")
@Document(value = "User")
public class User {


    @ApiModelProperty(value = "期望取快递的区域")
    private Long region_id;

    /* 学号 */
    @Id
    @ApiModelProperty(value = "用户ID")
    private Long studentID;

    /* 真实姓名 */
    @ApiModelProperty(value = "用户姓名")
    private String name;

    /* 余额 */
    @ApiModelProperty(value = "余额")
    private double balance;

    /* avatar_url */
    @ApiModelProperty(value = "头像URL")
    private String avatar_url;

    /* openid */
    @ApiModelProperty(value = "openID")
    private String open_id;

    @ApiModelProperty(value = "信用分")
    private double creditScore;

    @ApiModelProperty(value = "标签")
    private Tag tag;

    public User() {
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
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

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "region_id=" + region_id +
                ", studentID=" + studentID +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", avatar_url='" + avatar_url + '\'' +
                ", open_id='" + open_id + '\'' +
                ", creditScore=" + creditScore +
                ", tag=" + tag +
                '}';
    }
}