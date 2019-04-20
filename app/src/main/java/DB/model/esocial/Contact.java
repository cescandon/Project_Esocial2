package DB.model.esocial;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


@Entity(indices = {@Index(value = {"contactName", "email"}, unique = true)}, foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "uid",
        childColumns = "contactID"))
public class Contact{

    public long uid;

    @NonNull
    public String contactName;
    public String email;

    @Nullable
    public String first_name;
    public String last_name;
    public String phone;

    @PrimaryKey(autoGenerate = true)
    public long contactID;

    @Ignore
    public Contact(String _name, String _last, String _first, String _phone, String _email)
    {
        this.contactName = _name;
        this.last_name = _last;
        this.first_name = _first;
        this.phone = _phone;
        this.email = _email;

    }


    public void setId(long id) {
        this.contactID = id;
    }

    public long getId() {
        return contactID;
    }

    public String getContact() {
        return contactName;
    }

    public String getContactLN() {
        return last_name;
    }

    public String getContactFN() {
        return first_name;
    }

    public void setContact(String _name) {
        this.contactName = _name;
    }

    public void setContactLN(String _last) {
        this.last_name = _last;
    }

    public void setContactFN(String _first) {
        this.first_name = _first;
    }

    public String getContactPhone() {
        return phone;
    }

    public void setContactPhone(String _phone) {
        this.phone = _phone;
    }

    public String getContactEmail(){return email;}

    public void setContactEmail(String _email){this.email = _email;}

    public Contact() {
        this.contactName = "contactName";
        this.last_name = "last_name";
        this.first_name = "first_name";
        this.phone = "phone";
        this.email = "email";
    }

    public Contact(String _name)
    {
        this.contactName = _name;
    }


/*
    // create PK for contact class
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(contactName = "user_id")
    private int contactID; // primaru key for contact class column user_id

    //setter

    public void setContactID(int contactID) {
        this.contactID = contactID;}

    // getter for PK id
    public int getContactID() {
        return contactID;
    }

    // column list of user PK rowid
    @ColumnInfo(contactName = "rowid")
    public int userID; // variable for Foreign Key from user class

    // getter
    public int getUserID() {
        return userID;
    }


    // setter for contactID
    public void setUserID(int userID) {
        this.userID = userID;
    }

    // constructor
    public Contact()
    {

    }

    // create contact contactName
    @NonNull
    @ColumnInfo(contactName = "username")
    private String contact;

    // setter for contact username
    public void setContact(String contacter) {
        this.contact = contacter;
    }

    // getter for contact username
    @NonNull
    public String getContact() {
        return contact;
    }

    // create contact last contactName
    @Nullable
    @ColumnInfo(contactName = "last_name", index = true)
    public String cLast;

    // setter for last contactName contact class
    public void setcLast(String last) {
        this.cLast = last;
    }

    // getter for last

    @Nullable
    public String getcLast() {
        return cLast;
    }

    // create contact first contactName
    @Nullable
    @ColumnInfo(contactName = "first_name", index = true)
    public String cFirst;

    // setter for first contactName

    public void setcFirst(@Nullable String first) {
        this.cFirst = first;
    }

    // getter for first
    @Nullable
    public String getcFirst() {
        return cFirst;
    }

    // create contact phone info
    @Nullable
    @ColumnInfo(contactName = "phone")
    public String cPhone;

    // setter for phone contact

    public void setcPhone(@Nullable String phone) {
        this.cPhone = phone;
    }

    // getter for contact phone

    @Nullable
    public String getcPhone() {
        return cPhone;
    }

    @Nullable
    @ColumnInfo(contactName = "email")
    private String email;

    // setter for email

    public void setEmail(@Nullable String emailer) {
        this.email = emailer;
    }

    // getter
    @Nullable
    public String getEmail() {
        return email;
    }

    // using contactName and email
    @Ignore
    public Contact(String contactName, String email)
    {
        this.contact = contactName;
        this.email = email;
    }
*/
    // Embedded Address option calling Address class
    @Embedded
    public Address address;



}