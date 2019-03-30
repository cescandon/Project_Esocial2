package com.example.esocialapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MyAllContactsRecyclerViewAdapter.ItemClickListener {

    public static final String EXTRA_LIST = "com.example.esocialapp.LIST";
    MyAllContactsRecyclerViewAdapter adapter;
    AllContacts allContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hard code the RecyclerView
        allContacts = new AllContacts();
        allContacts.addCategory("Contacts");
        ContactList contactList = allContacts.getCategory(0);
        contactList.addContact(new Contact("John Doe", "3235559999", "", "someone.@somewhere.com"));
        contactList.addContact(new Contact("Ron Reagan"));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvPeople);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAllContactsRecyclerViewAdapter(this, allContacts);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, DisplayContactList.class);
        intent.putExtra(EXTRA_LIST, allContacts.getCategory(position));

        startActivity(intent);
    }
}


