package DB.model.esocial;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import view.cycler.esocial.ContactActivity;
import view.cycler.esocial.UsersRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = 1;

    private UserViewModel mUserViewModel;

    User user = new User();
    UserDao uDao;
    ContactDao cDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // populate data
        user = new User("Sam02");
        uDao.insertUser(user);
        user = new User("john3:16");
        uDao.insertUser(user);
        Contact contact = new Contact("James");
        cDao.insertContact(contact);
        uDao.insertWithFriends(user,cDao.getllContacts());


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UsersRecyclerViewAdapter adapter = new UsersRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mUserViewModel.getmUserLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable final List<User> userList) {
                // Update the cached copy of the words in the adapter.
                adapter.setData(userList);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, User.class);
                startActivityForResult(intent, NEW_CONTACT_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_CONTACT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            User user = new User(data.getStringExtra(ContactActivity.EXTRA_REPLY));
            mUserViewModel.insertUserModel(user);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.app_name,
                    Toast.LENGTH_LONG).show();
        }
    }
}
