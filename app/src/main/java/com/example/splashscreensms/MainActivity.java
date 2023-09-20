package com.example.splashscreensms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phone_number,message;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone_number=findViewById(R.id.phone_number);
        message=findViewById(R.id.message);
        button=findViewById(R.id.button);

        SmsSender();


    }

    private void SmsSender() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber=phone_number.getText().toString();
                String messageComp=message.getText().toString();
                if(phoneNumber.isEmpty() && messageComp.isEmpty()){
                    Toast.makeText(MainActivity.this, "FIll The Both Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber,null,messageComp,null,null);
                    Toast.makeText(MainActivity.this, "Hopefully Message Sended", Toast.LENGTH_LONG).show();
                    phone_number.setText("");
                    message.setText("");
                }

            }
        });

    }
}