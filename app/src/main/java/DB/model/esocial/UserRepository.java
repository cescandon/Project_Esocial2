package DB.model.esocial;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;
import java.util.Observer;

public class UserRepository {

    private UserDao mUserDao;
    private LiveData<List<User>> mAllUsers;

    public UserRepository(Application application) {
        UserRoomDatabase Userdb = UserRoomDatabase.getDatabase(application);
        this.mUserDao = Userdb.userDao();
        this.mAllUsers = mUserDao.getAllLiveList();
    }

    public LiveData<List<User>>getAllUsers()
    {
        return mAllUsers;
    }

    // create AsyncTask for each Dao activity: Insert, Delete to avoid crash when called
    // *****************************
    // to avoid data crash on insert
    public void insert(User user)
    {
        new insertAsyncTask(mUserDao).execute(user);
    }


    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insertUser(params[0]);
            return null;
        }
    }

    // *************************
    // To avoid crash on Delete
    public void deleteItem(User user) {
        new deleteAsyncTask(mUserDao).execute(user);

    }

    private static class deleteAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mAsyncTaskDao;
        deleteAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.deleteUser(params[0]);
            return null;
        }
    }

    public void deleteItemById(Long idItem) {
        new deleteByIdAsyncTask(mUserDao).execute(idItem);
    }

    private static class deleteByIdAsyncTask extends AsyncTask<Long, Void, Void> {
        private UserDao mAsyncTaskDao;
        deleteByIdAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Long... params) {
            mAsyncTaskDao.deleteUserbyID(params[0]);
            return null;
        }
    }


}
