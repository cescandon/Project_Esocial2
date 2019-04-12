package com.project.esocial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.reminders.Reminder;
import com.project.reminders.ReminderList;

public class RemListViewAdapter extends RecyclerView.Adapter<RemListViewAdapter.ViewHolder>{

    private ReminderList mData;
    private LayoutInflater mInflater;
    private RemListViewAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    RemListViewAdapter(Context context, ReminderList data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public RemListViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new RemListViewAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(RemListViewAdapter.ViewHolder holder, int position) {
        Reminder reminder = mData.getReminders().get(position);
        holder.myTextView.setText(reminder.getDesc());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.getReminders().size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvReminderName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getMyItem(int id) {
        return mData.getReminders().get(id).getDesc();
    }

    // allows clicks events to be caught
    void setClickListener(RemListViewAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
