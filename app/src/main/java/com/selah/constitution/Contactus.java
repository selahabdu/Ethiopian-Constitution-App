package com.selah.constitution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class Contactus extends AppCompatActivity {
    Button sendbtn;
    EditText emailtxt,subjecttext ,etmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
         emailtxt=findViewById(R.id.emailtext);
         subjecttext=findViewById(R.id.textsubject);
         etmessage=findViewById(R.id.textmessage);
         sendbtn=findViewById(R.id.sendbutton);

         sendbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(Intent.ACTION_VIEW
                 , Uri.parse("mail to:"+emailtxt.getText().toString()));
                 intent.putExtra(Intent.EXTRA_SUBJECT, subjecttext.getText().toString());
                 intent.putExtra(Intent.EXTRA_TEXT,etmessage.getText().toString());
                 startActivity(intent);
             }
         });

    }
}