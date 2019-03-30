package com.example.esocialapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DisplayContactList extends AppCompatActivity implements ContactListRecyclerViewAdapter.ItemClickListener {
   ContactList contactList;
   ContactListRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact_list);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        contactList = (ContactList) intent.getSerializableExtra(MainActivity.EXTRA_LIST);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvContactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactListRecyclerViewAdapter(this, contactList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
