package ru.tim.pizzApp.entity;

public class User {
    private int user_id;
    private String name;
    private String email;
    private int phone;
    private String address;


    public User(int user_id, String name, String email, int phone, String address) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public User(){

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
