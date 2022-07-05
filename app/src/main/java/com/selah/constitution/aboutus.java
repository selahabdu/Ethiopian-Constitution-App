  package com.selah.constitution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

  public class aboutus extends AppCompatActivity {
Button contactbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        contactbutton=findViewById(R.id.btncontact);
        contactbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactIntent=new Intent(getApplicationContext(),Contactus.class);
                startActivity(contactIntent);
            }
        });

    }
}