package com.example.sqliteapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button button;
        button = findViewById(R.id.btnviewAllCus);
        button.setOnClickListener(v -> startListShowActivity());

    }
    public void startListShowActivity(){
        Intent intent = new Intent(this, UsersList.class);
        startActivity(intent);
    }
}