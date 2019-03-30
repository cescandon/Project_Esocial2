package com.example.esocialapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactList implements Serializable
{
    private final String category;
    private final List<Contact> contacts;

    // create a contact category for display in app
    public ContactList(String _cat)
    {
        category = _cat;
        contacts = new ArrayList<>();
    }

    // add a contact object
    public void addContact(Contact _contact)
    {
        contacts.add(_contact);
    }

    // print category name
    @Override
    public String toString()
    {
        return category;
    }

    // get the contacts in list
    public List<Contact> getContacts()
    {
        return contacts;
    }


}
