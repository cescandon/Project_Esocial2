package DB.model.esocial;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    private ContactRepository mContactRepo;

    private LiveData<List<Contact>> mContactLiveData;

    public ContactViewModel (Application application) {
        super(application);
        mContactRepo = new ContactRepository(application);
        mContactLiveData = mContactRepo.getAllContacts();
    }

    LiveData<List<Contact>> getmContactLiveData() { return mContactLiveData; }


    public void insertContactModel(Contact contact) { mContactRepo.insert(contact); }

    public void deleteContactModel(Contact contact){ mContactRepo.deleteItem(contact);}

    public void deleteByContactIdModel(long id){mContactRepo.deleteItemById(id);}

}
