package DB.model.esocial;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContactDao {

    // insert a contact
    @Insert
    void insertContact(Contact contact);

    @Insert
    void saveAllContact(List<Contact>contactList);



    // Query

    // find  contacts by username and email
    @Query("SELECT * FROM contact WHERE contactName LIKE:name AND email Like:email")
    Contact contact(String name, String email);

    // List all contacts
    @Query("SELECT * FROM contact")
    List<Contact>getllContacts();

    // list all contacts live data
    @Query("SELECT * FROM contact")
    LiveData<List<Contact>>getallContactsLive();

    // Updates and update with queries
    @Update
    int updateContact(Contact contact);

    // update Last name
    @Query("UPDATE contact SET last_name =:clast WHERE contactID = :id")
    int updateContactLN(String clast, int id);

    // update first name
    @Query("UPDATE contact SET first_name =:first WHERE contactID = :id")
    int updateContactFN(String first, int id);

    // update phone
    @Query("UPDATE contact SET phone =:phone WHERE contactID = :id")
    int updateContactPhone(String phone, int id);

    // update email contact
    @Query("UPDATE contact SET email =:email WHERE contactID = :id")
    int updateContactEmail(String email, int id);



    // Delete, return int to see rows affected. else use void

    // delete contact
    @Delete
    void deleteContact(Contact contact);

    // delete all contacts
    @Delete
    void deleteAll(List<Contact>contactList);

    // delete by Query of id
    @Query("DELETE FROM contact WHERE contactID = :id")
    void deleteContactbyID(long id);

    // delete all using Query
    @Query("DELETE FROM contact")
    void deleteAll();







}
