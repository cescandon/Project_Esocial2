package com.project.esocial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.project.reminders.AllReminders;
import com.project.reminders.Reminder;

public class RemCategoryActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders_main);

        // data to populate the RecyclerView with
        AllReminders allreminders = new AllReminders();

        allreminders.addCategory("Personal");
        allreminders.addCategory("Work");
        allreminders.addCategory("School");
        allreminders.addCategory("Medical");

        allreminders.getCategory(0).add(new Reminder("Do laundry"));
        allreminders.getCategory(1).add(new Reminder("Finish Business Report"));
        allreminders.getCategory(2).add(new Reminder("Turn in homework."));
        allreminders.getCategory(3).add(new Reminder("Take allergy medicine."));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);


        RecyclerView recyclerView = findViewById(R.id.rvRems);
        recyclerView.setLayoutManager( layoutManager );
        adapter = new MyRecyclerViewAdapter(this, allreminders);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(View view, int position) {

        //Setup an intent
        Intent startIntent = new Intent(getApplicationContext(), RemListActivity.class);
        //pass info to another activity
        startIntent.putExtra("MyReminderList", adapter.getMyList(position));

        Toast.makeText(this, "You clicked " + adapter.getMyItem(position) + " on row", Toast.LENGTH_SHORT).show();

        //Start Activity
        startActivity(startIntent);

    }
}