package com.example.myclass;

public class DataModal {

    // variables for storing our image and name.
    private String Name;
    private String RegisterNo;
    private String ClassandSec;
    private String date;
    private Integer count;

    public DataModal() {
        // empty constructor required for firebase.
    }

    // constructor for our object class.
    public DataModal(String Name, String RegisterNo,String date,Integer count, String ClassandSec) {
        this.Name = Name;
        this.RegisterNo = RegisterNo;
        this.date = date;
        this.ClassandSec=ClassandSec;
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

    public String getClassandSec() {
        return ClassandSec;
    }

    public void setClassandSec(String ClassandSec) {
        this.ClassandSec = ClassandSec;
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
