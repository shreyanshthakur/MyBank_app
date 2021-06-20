package com.example.sqliteapplication2.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqliteapplication2.R;
import com.example.sqliteapplication2.Data.User;
import com.example.sqliteapplication2.Activities.UserData;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private final ArrayList<User> userArrayList;

    public UserListAdapter(ArrayList<User> list){
        userArrayList = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName, userAccountBalance, email;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            userName = itemView.findViewById(R.id.username);
            userAccountBalance = itemView.findViewById(R.id.amount);
            email = itemView.findViewById(R.id.tvEmail);

            itemView.setOnClickListener(view -> {
                // still to be implemented
            });
        }
    }
    @NonNull
    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.users_list_item, viewGroup, false);
        return new ViewHolder(view);
    }


    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(userArrayList.get(position));
        viewHolder.userName.setText(userArrayList.get(position).getName());
        viewHolder.email.setText(userArrayList.get(position).getEmail());

        viewHolder.userAccountBalance.setText(String.format("%d", userArrayList.get(position).getBalance()));

        viewHolder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), UserData.class);
            intent.putExtra("ACCOUNT_NO", userArrayList.get(position).getAccountNumber());
            intent.putExtra("NAME", userArrayList.get(position).getName());
            intent.putExtra("EMAIL", userArrayList.get(position).getEmail());
            intent.putExtra("PHONE_NO", userArrayList.get(position).getPhoneNumber());
            intent.putExtra("BALANCE", String.valueOf(userArrayList.get(position).getBalance()));
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
}