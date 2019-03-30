package com.example.esocialapp;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String number;
    private String desc;
    private String email;

    //constructor for contact if only input is name
    public Contact(String _name)
    {
        name = _name;
    }

    // constructor for other variables
    public Contact(String _name, String _num, String _des, String _email)
    {
        name = _name;
        number = _num;
        desc = _des;
        email = _email;

    }

    // setters for individual variables
    public void setName(String _na)
    {
        name = _na;
    }

    public void setNumber(String _nu)
    {
        number = _nu;
    }

    public void setDesc(String _d)
    {
        desc = _d;
    }

    public void setEmail(String _em)
    {
        email = _em;
    }

    // getters
    public String getName()
    {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getDesc() {
        return desc;
    }

    public String getEmail() {
        return email;
    }


}
