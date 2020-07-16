package ru.tim.pizzApp.entity;

import java.sql.Date;
import java.sql.Time;

public class Order {
    private int id;
    private String userLogin;
    private String userName;
    private String deliveryAddress;
    private String phone;
    private String order;
    private String notice;
    private String status;
    private double price;
    private Date date;
    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order() {
    }

    public Order(int id, String userLogin, String userName, String deliveryAddress, String phone, String order, String notice, String status, double price, Date date) {
        this.id = id;
        this.userLogin = userLogin;
        this.userName = userName;
        this.deliveryAddress = deliveryAddress;
        this.phone = phone;
        this.order = order;
        this.notice = notice;
        this.status = status;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
