package DB.model.esocial;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AddressDao {

    // Insert address
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAddress(Address address);


    // Query

    // query by zip
    @Query("SELECT * FROM contact WHERE post_code = :postCode")
    List<Contact>getContactbyZip();

    // update

    //update street
    @Query("SELECT * FROM contact WHERE street = :street")
    void updateStreet(String street);

    //update state
    @Query("SELECT * FROM contact WHERE state = :state")
    void updateState(String state);

    // update city
    @Query("SELECT * FROM contact WHERE city = :city")
    void updateCity(String city);

    // update zip
    @Query("SELECT * FROM contact WHERE post_code = :post")
    void updateZip(int post);

    // delete
    @Delete
    int deleteAddress(Address address);


}
