package DB.model.esocial;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mUserRepo;

    private LiveData<List<User>> mUserLiveData;

    public UserViewModel (Application application) {
        super(application);
        mUserRepo = new UserRepository(application);
        mUserLiveData = mUserRepo.getAllUsers();
    }

    public LiveData<List<User>> getmUserLiveData() { return mUserLiveData; }

    public void insertUserModel(User user) { mUserRepo.insert(user); }

    public void deleteUserModel(User user){ mUserRepo.deleteItem(user);}

    public void deleteByUserIdModel(long id){mUserRepo.deleteItemById(id);}

}
