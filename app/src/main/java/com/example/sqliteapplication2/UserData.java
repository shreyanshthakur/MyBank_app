package com.example.sqliteapplication2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserData extends AppCompatActivity {

    TextView name, email, accountNo, balance, ifscCode, phoneNo;
    Button transferMoney;
    AlertDialog dialog;

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

        transferMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to be filled
            }
        });
    }

}