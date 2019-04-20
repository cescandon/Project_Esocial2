package DB.model.esocial;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface UserDao {

    // add a user
    @Insert
    void insertUser(User users);

    // insert all users. may need to allow conflict strategy on insert
    @Insert
    void saveAllUsers(List<User>users);

    // insert with contacts
    @Insert
    void insertWithFriends(User user, List<Contact> contacts);


    // query by id
    @Query("SELECT * FROM user_table WHERE `rowid` =:id")
    LiveData<User> getLiveUserById(int id);

    // List all users from query Live
    @Query("SELECT * FROM user_table")
    LiveData<List<User>>getAllLiveList();

    // List all users from query
    @Query("SELECT * FROM user_table")
    List<User>getUserList();



    // Query users by indeces
    @Query("SELECT * FROM user_table WHERE name LIKE:name AND email LIKE :email")
    List<User> findUser(String name, String email);

    // Query user by name
    @Query("SELECT * FROM user_table WHERE name LIKE:name")
    List<User> findbyUsername(String name);

    // Query user by uid
    @Query("SELECT * FROM user_table WHERE `rowid` = :uid")
    List<User> findUID(int uid);

    // Query by id live data
    @Query("SELECT * FROM user_table WHERE `rowid` = :uid")
    LiveData<User>findUIDLive(int uid);


    // Updates
    @Update
    void updateUser(User user);

    // Update first name
    @Query("UPDATE user_table SET first_name = :first WHERE `rowid` = :id")
    void updateFirstN(String first, int id);

    // Update last name
    @Query("UPDATE user_table SET last_name = :last WHERE `rowid` = :id")
    void updateLastN(String last, int id);

    // Update phone
    @Query("UPDATE user_table SET phone = :phone WHERE `rowid` = :id")
    void updateUserPhone(String phone, int id);

    // Update email
    @Query("UPDATE user_table SET email = :email WHERE `rowid` = :id")
    void updateUserEmail(String email, int id);

    // Update password
    //@Query("UPDATE user_table SET password = :pass WHERE `rowid` = :id")
    //void updateUserPass(String pass, int id);


    // deletes are int values to return affected rows. change to void if int not required.
    // delete user
    @Delete
    void deleteUser(User user);

    // delete by Query of id
    @Query("DELETE FROM user_table WHERE uid = :userid")
    void deleteUserbyID(long userid);

    // delete all using Query
    @Query("DELETE FROM user_table")
    void deleteAll();

    // delete all users
    @Delete
    void deleteAll(List<User>userList);

    // delete user with contacts
    @Delete
    void deleteWithContacts(User user, List<Contact>contactList);


}
