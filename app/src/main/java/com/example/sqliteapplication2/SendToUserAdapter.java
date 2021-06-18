package com.example.sqliteapplication2;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SendToUserAdapter extends RecyclerView.Adapter<SendToUserAdapter.ViewHolder> {
    private final ArrayList<User> userArrayList;
    private final OnUserListener onUserListener;

    public SendToUserAdapter(ArrayList<User> userArrayList, OnUserListener onUserListener) {
        this.userArrayList = userArrayList;
        this.onUserListener = onUserListener;
    }

    @NonNull
    @Override
    public SendToUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view, onUserListener);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull SendToUserAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(userArrayList.get(position));
        viewHolder.userName.setText(userArrayList.get(position).getName());
        viewHolder.userAccountBalance.setText(String.format("%d", userArrayList.get(position).getBalance()));
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView userName, userAccountBalance;
        OnUserListener onUserListener;

        public ViewHolder(@NonNull View itemView, OnUserListener onUserListener) {
            super(itemView);
            userName = itemView.findViewById(R.id.username);
            userAccountBalance = itemView.findViewById(R.id.amount);
            this.onUserListener = onUserListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onUserListener.onUserClick(getAdapterPosition());
        }
    }

    public interface OnUserListener {
        void onUserClick(int position);
    }
}
