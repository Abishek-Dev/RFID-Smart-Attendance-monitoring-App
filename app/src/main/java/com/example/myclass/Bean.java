package com.example.myclass;

public class Bean {
    String initial, firstName, middleName, lastName;

    Bean(String initial, String firstName, String middleName, String lastName) {
        this.initial = initial;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getInitial() {
        return initial;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
}
