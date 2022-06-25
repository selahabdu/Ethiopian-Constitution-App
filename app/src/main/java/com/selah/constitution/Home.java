package com.selah.constitution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class Home extends AppCompatActivity {
    ListView listView;

    String[] articles={
            //try to declare with loop
            "Article 1",
            "Article 2",
            "Article 3",
            "Article 4",
            "Article 5",
            "Article 6",
            "Article 7",
            "Article 8",
            "Article 9",
            "Article 10",
            "Article 11",
    };
    String[] description = {
            "Nomenclature of the State",
            "Ethiopian Territorial Jurisdiction",
            "The Ethiopian Flag",
            "National Anthem of Ethiopia",
            "Languages",
            "Nationality",
            "Gender Reference",
            "Sovereignty of the People",
            "Supremacy of the Constitution",
            "Human and Democratic Rights",
            "Separation of State and Religion"

    };
    private Integer[] images = {
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article,
            R.drawable.icon_article
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        articleListAdapter articleListAdapterAdapter = new articleListAdapter(this,articles,description,images);

        listView = findViewById(R.id.articles_list_view);
        listView.setAdapter(articleListAdapterAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected" + position, Toast.LENGTH_LONG).show();

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =  getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.item_exit:
                exitApp();
                return true;
            case R.id.item_share:
                shareApp();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
    public void exitApp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setMessage("Do You Want To Exit ?");
        builder.setCancelable(true);
        //
        builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        //
        builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void shareApp(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND); // because we sent some txt
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Ethiopian Constitution");
        String shareMessage;
        shareMessage = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n"; // add package name
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        startActivity(Intent.createChooser(shareIntent, "Share Using"));
    }



}