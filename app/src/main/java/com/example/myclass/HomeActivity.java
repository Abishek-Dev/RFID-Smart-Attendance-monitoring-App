package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
Button attendancebtn,unregisteredbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        attendancebtn=(Button)findViewById(R.id.attendancebtn);
        unregisteredbtn=(Button)findViewById(R.id.unregisteredbtn);
        attendancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),attendance.class);
                startActivity(i);
                /*FirebaseAuth.getInstance().signOut();
                finish();*/
            }
        });
    }
}