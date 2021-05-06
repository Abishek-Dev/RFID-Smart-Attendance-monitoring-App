package com.example.myclass;

public class UserHelperClass {
    String name,classandsec, email, phone, password;
    public UserHelperClass() {
    }
    public UserHelperClass(String name, String classandsec, String email, String phone, String password) {
        this.name = name;
        this.classandsec = classandsec;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClassandsec() {
        return classandsec;
    }
    public void setClassandsec(String classandsec) {
        this.classandsec = classandsec;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNo() {
        return phone;
    }
    public void setPhoneNo(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
