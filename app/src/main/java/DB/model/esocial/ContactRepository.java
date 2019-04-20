package DB.model.esocial;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ContactRepository {
    private ContactDao mContactDao;
    private LiveData<List<Contact>> mAllContacts;

    public ContactRepository(Application application) {
        ContactRoomDatabase Contactdb = ContactRoomDatabase.getDatabase(application);
        this.mContactDao = Contactdb.contactDao();
        this.mAllContacts = mContactDao.getallContactsLive();
    }

    public LiveData<List<Contact>>getAllContacts()
    {
        return mAllContacts;
    }

    // create AsyncTask for each Dao activity: Insert, Delete to avoid crash when called
    // *****************************
    // to avoid data crash on insert
    public void insert(Contact contact)
    {
        new insertAsyncTask(mContactDao).execute(contact);
    }


    private static class insertAsyncTask extends AsyncTask<Contact, Void, Void> {

        private ContactDao mAsyncTaskDao;

        insertAsyncTask(ContactDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contact... params) {
            mAsyncTaskDao.insertContact(params[0]);
            return null;
        }
    }

    // *************************
    // To avoid crash on Delete
    public void deleteItem(Contact contact) {
        new deleteAsyncTask(mContactDao).execute(contact);

    }

    private static class deleteAsyncTask extends AsyncTask<Contact, Void, Void> {
        private ContactDao mAsyncTaskDao;
        deleteAsyncTask(ContactDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contact... params) {
            mAsyncTaskDao.deleteContact(params[0]);
            return null;
        }
    }

    public void deleteItemById(Long idItem) {
        new deleteByIdAsyncTask(mContactDao).execute(idItem);
    }

    private static class deleteByIdAsyncTask extends AsyncTask<Long, Void, Void> {
        private ContactDao mAsyncTaskDao;
        deleteByIdAsyncTask(ContactDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Long... params) {
            mAsyncTaskDao.deleteContactbyID(params[0]);
            return null;
        }
    }

}
