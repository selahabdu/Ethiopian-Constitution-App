package com.selah.constitution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Contactus extends AppCompatActivity {
EditText nametxt,emailtxt;
Button sendbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        nametxt=findViewById(R.id.textname);
        emailtxt=findViewById(R.id.emailtext);
    }
}