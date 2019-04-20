package DB.model.esocial;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;


@Entity(tableName = "user_table", indices = {@Index(value = {"name", "email"}, unique = true)})
public class User
{
    @NonNull
    public String name;
    public String email;

    @Nullable
    public String first_name;
    public String last_name;
    public String phone;

    @PrimaryKey(autoGenerate = true)
    public long uid;

    @Ignore
    public User(String _name, String _last, String _first, String _phone, String _email)
    {
        this.name = _name;
        this.last_name = _last;
        this.first_name = _first;
        this.phone = _phone;
        this.email = _email;

    }


    public void setId(long id) {
        this.uid = id;
    }

    public long getId() {
        return uid;
    }

    public String getUserName() {
        return name;
    }

    public String getUserLN() {
        return last_name;
    }

    public String getUserFN() {
        return first_name;
    }

    public void setUserName(String _name) {
        this.name = _name;
    }

    public void setUserLN(String _last) {
        this.last_name = _last;
    }

    public void setUserFN(String _first) {
        this.first_name = _first;
    }

    public String getUserPhone() {
        return phone;
    }

    public void setUserPhone(String _phone) {
        this.phone = _phone;
    }

    public String getUserEmail(){return email;}

    public void setUserEmail(String _email){this.email = _email;}

    public User() {
        this.name = "name";
        this.last_name = "last_name";
        this.first_name = "first_name";
        this.phone = "phone";
        this.email = "email";
    }

    public User(String _name)
    {
        this.name = _name;
    }


    /*

    // constructor
    public User(){

    }


    // create an id column and use for PK
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rowid")
    public int uid;

    // create passing uid
    public void setUser(int _uid)
    {
        this.uid = _uid;
    }


    // getter for uid
    public int getUID()
    {
        return uid;
    }


    // create a name column, index to unique value
    @NonNull
    @ColumnInfo(name = "name")
    private String name;


    // setter of user by name
    public void setName(String usernamer) {
        this.name = usernamer;
    }

    // getter for name
    @NonNull
    public String getName()
    {
        return name;
    }

    // create a last name column
    @ColumnInfo(name = "last_name")
    private String lastName;

    // setter for lastname
    public void setLastName(String lastNamer) {
        this.lastName = lastNamer;
    }

    // getter for lastname
    public String getLastName()
    {
        return lastName;
    }

    // create a first name column
    @ColumnInfo(name = "first_name")
    private String firstName;

    // setter for first name
    public void setFirstName(String firstNamer) {
        this.firstName = firstNamer;
    }

    // getter for first name

    public String getFirstName() {
        return firstName;
    }

    // create column for phone(any mode of comms)
    @ColumnInfo(name = "phone")
    private String phoneDigits;

    // setter for phone
    public void setPhoneDigits(String _phoneDigits) {
        this.phoneDigits = _phoneDigits;
    }

    // getter for phone
    public String getPhoneDigits() {
        return phoneDigits;
    }

    // create a column for email
    @Nullable
    @ColumnInfo(name = "email")
    private String email;

    // setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // getter for email
    public String getEmail() {
        return email;
    }

    // create column for email
    @NonNull
    @ColumnInfo(name = "password")
    private String passW;


    // setter for pass
    public void setPassW(String passW) {
        this.passW = passW;
    }

    // getter for pass
    @NonNull
    public String getPassW() {
        return passW;
    }

    // constructor using name and pass
    public User(@NonNull String tag, String pass)
    {
        this.name = tag;
        this.passW = pass;
    }

    public long getUid() {
        return uid;
    }

    // using username and uid
    @Ignore
    public User(String name, int id)
    {
        this.name = name;
        this.uid = id;
    }

    // create contacts column
    @Nullable
    @Ignore
    @ColumnInfo(name = "contacts")
    public List<Contact> contact;

    @Ignore
    Address address;

*/
}
