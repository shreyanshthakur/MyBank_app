package com.example.sqliteapplication2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.sqliteapplication2.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnAllUsers,btnTransactions;
        btnAllUsers = findViewById(R.id.btnviewAllCus);
        btnTransactions = findViewById(R.id.btnviewAllTrans);
        btnAllUsers.setOnClickListener(v -> startListShowActivity());
        btnTransactions.setOnClickListener(v -> startTransactionsHistoryActivity());

    }
    public void startListShowActivity(){
        Intent intent = new Intent(this, UsersList.class);
        startActivity(intent);
    }

    public void startTransactionsHistoryActivity(){
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }
}