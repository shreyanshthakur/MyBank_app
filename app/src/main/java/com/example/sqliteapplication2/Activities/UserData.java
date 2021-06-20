package com.example.sqliteapplication2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqliteapplication2.R;

public class UserData extends AppCompatActivity {

    TextView name, email, accountNo, balance, phoneNo;
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

        transferMoney.setOnClickListener(v -> enterAmount());
    }

    private void enterAmount(){
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.transaction_dialog_box, null);
        mBuilder.setTitle("Enter Amount").setView(mView).setCancelable(false);

        final EditText mAmount = mView.findViewById(R.id.enter_money);
        mBuilder.setPositiveButton("SEND", (dialog, which) -> {

        }).setNegativeButton("CANCEL", (dialog, which) -> {
            dialog.dismiss();
            transactionCancel();
        });

        dialog = mBuilder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(view -> {
            // Checking whether amount entered is correct or not
            int currentBalance = Integer.parseInt(String.valueOf(balance.getText()));

            if (mAmount.getText().toString().isEmpty()) {
                mAmount.setError("Amount can't be empty");
            } else if (Integer.parseInt(mAmount.getText().toString()) > currentBalance){
                mAmount.setError("Your account don't have enough balance");
            } else {
                Intent intent = new Intent(UserData.this, SendToUserList.class);
                intent.putExtra("FROM_USER_ACCOUNT_NO", Integer.parseInt(accountNo.getText().toString()));    // PRIMARY_KEY
                intent.putExtra("FROM_USER_NAME", name.getText());
                intent.putExtra("FROM_USER_ACCOUNT_BALANCE", balance.getText());
                intent.putExtra("TRANSFER_AMOUNT", mAmount.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }

    private void transactionCancel() {
        AlertDialog.Builder builder_exitbutton = new AlertDialog.Builder(UserData.this);
        builder_exitbutton.setTitle("Do you want to cancel the transaction?").setCancelable(false)
                .setPositiveButton("yes", (dialogInterface, i) -> Toast.makeText(UserData.this, "Transaction Cancelled!", Toast.LENGTH_LONG).show()).setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                    enterAmount();
                });
        AlertDialog alertexit = builder_exitbutton.create();
        alertexit.show();
    }
}