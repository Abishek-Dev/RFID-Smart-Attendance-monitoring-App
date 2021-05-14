package com.example.myclass;

public class DataModal {

    // variables for storing our image and name.
    private String Name;
    private String RegisterNo;
    private String classandSec;
    private String date;
    private Integer count;

    public DataModal() {
        // empty constructor required for firebase.
    }

    // constructor for our object class.
    public DataModal(String Name, String RegisterNo,String date,Integer count, String classandSec) {
        this.Name = Name;
        this.RegisterNo = RegisterNo;
        this.date = date;
        this.classandSec=classandSec;
        this.count=count;
    }

    // getter and setter methods
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getRegisterNo() {
        return RegisterNo;
    }

    public void setRegisterNo(String RegisterNo) {
        this.RegisterNo = RegisterNo;
    }

    public String getclassandSec() {
        return classandSec;
    }

    public void setclassandSec(String classandSec) {
        this.classandSec = classandSec;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
