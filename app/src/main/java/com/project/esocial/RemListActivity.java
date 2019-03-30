package com.project.esocial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.project.reminders.ReminderList;

public class RemListActivity extends AppCompatActivity implements RemListViewAdapter.ItemClickListener{

    RemListViewAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders_second);

        //Check if there is any data being passed in from putExtras
        if(getIntent().hasExtra("MyReminderList")){
            //Assigning the stuff we passed in from main activity
            ReminderList remlist = (ReminderList) getIntent().getSerializableExtra("MyReminderList");

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);

            RecyclerView recyclerView = findViewById(R.id.rvReminderList);
            recyclerView.setLayoutManager( layoutManager );

            adapter2 = new RemListViewAdapter(this, remlist);
            adapter2.setClickListener(this);
            recyclerView.setAdapter(adapter2);

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                    layoutManager.getOrientation());
            recyclerView.addItemDecoration(dividerItemDecoration);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter2.getMyItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
