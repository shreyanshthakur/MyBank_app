package com.example.sqliteapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserData extends AppCompatActivity {

    TextView name, email, accountNo, balance, phoneNo;
    Button transferMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        accountNo = findViewById(R.id.account_no);
        balance = findViewById(R.id.avail_balance);
        phoneNo = findViewById(R.id.phone_no);
        transferMoney = findViewById(R.id.btnTransferMoney);

        // Getting the intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        // Extracting the data
        if (extras != null){
            name.setText(extras.getString("NAME"));
            accountNo.setText(String.valueOf(extras.getInt("ACCOUNT_NO")));
            email.setText(extras.getString("EMAIL"));
            phoneNo.setText(extras.getString("PHONE_NO"));
            balance.setText(extras.getString("BALANCE"));
        }
        else {
            Log.d("TAG", "Empty Intent");
        }

        transferMoney.setOnClickListener(v -> {
            //to be filled
        });
    }

}