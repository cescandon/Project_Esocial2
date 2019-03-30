package com.example.esocialapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllContacts implements Serializable
{
    // save contact list to file instead of database
    private static final String savetoFile = "contacts.db";
    private final List<ContactList> allContacts;
    private int noContact = -1;
    private int listID;

    // constructor
    public AllContacts()
    {
        allContacts = new ArrayList<>();
        listID = noContact;
    }

    public void addCategory(String addCat)
    {
        allContacts.add(new ContactList(addCat));
    }

    public List<ContactList> getCategories()
    {
        return allContacts;
    }

    public void setFocus(int currentList)
    {
        // adds to current list
        listID = currentList;
    }

    public void addContact(Contact con)
    {
        // adds contact to current list view
        allContacts.get(listID).addContact(con);
    }

    public ContactList getCategory(int list)
    {
        return allContacts.get(list);
    }

    // create file to act as database
    public static void save(AllContacts saveContacts)
    {
    ObjectOutputStream saveFile = null;
    try {
    saveFile = new ObjectOutputStream(new FileOutputStream(savetoFile));
    saveFile.writeObject(saveContacts);
    saveFile.close();
    } catch (
    FileNotFoundException ex) {
    Logger.getLogger(AllContacts.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(AllContacts.class.getName()).log(Level.SEVERE, null, ex);
} finally {
    try {
        saveFile.close();
    } catch (IOException ex) {
        Logger.getLogger(AllContacts.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}

    // Load all reminders from disk
    // If file not found, return new object with "Personal" list
    public static AllContacts load()  {
        AllContacts savedContacts;
        try {
            ObjectInputStream saveFile = new ObjectInputStream(new FileInputStream(savetoFile));
            savedContacts = (AllContacts) saveFile.readObject();
            saveFile.close();
            return savedContacts;
        } catch (IOException | ClassNotFoundException ex) {

        }
        savedContacts = new AllContacts();
        savedContacts.addCategory("Contacts");
        save(savedContacts);
        return savedContacts;
    }
}
