package ru.tim.pizzApp.entity;

public class Bucket {

    private int id;
    private String user_login;
    private String order;
    private String additives;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAdditives() {
        return additives;
    }

    public void setAdditives(String additives) {
        this.additives = additives;
    }

    public Bucket() {
    }

    public Bucket(int id, String user_login,  String order, String additives, double price) {
        this.id = id;
        this.user_login = user_login;
        this.order = order;
        this.additives = additives;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


}
