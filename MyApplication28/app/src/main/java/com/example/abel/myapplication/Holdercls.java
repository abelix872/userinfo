package com.example.abel.myapplication;

public class Holdercls {


    private string fullname;
    private string email;
    private string gender;

    public Holdercls(string fullname, string email, string gender, string password, string email1, string mobile, string username) {
        this.fullname = fullname;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.email = email1;
        this.mobile = mobile;
        this.username = username;
    }

    private string password;
    private string email;

    public void setFullname(string fullname) {
        this.fullname = fullname;
    }

    public void setEmail(string email) {
        this.email = email;
    }

    public void setMobile(string mobile) {
        this.mobile = mobile;
    }

    public void setUsername(string username) {
        this.username = username;
    }

    public void setGender(string gender) {
        this.gender = gender;
    }

    public void setPassword(string password) {
        this.password = password;
    }

    private string mobile;

    public string getFullname() {
        return fullname;
    }

    public string getEmail() {
        return email;
    }

    public string getMobile() {
        return mobile;
    }

    public string getUsername() {
        return username;
    }

    public string getGender() {
        return gender;
    }

    public string getPassword() {
        return password;
    }

    private string username;

    public Holdercls() {
    }

}
