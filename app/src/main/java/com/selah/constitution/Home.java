package com.selah.constitution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;

public class Home extends AppCompatActivity {
    ListView listView;


    private Integer[] images = new Integer[14];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Resources resources = getResources();
        String[] articles = resources.getStringArray(R.array.article_names);
        String[] description = resources.getStringArray(R.array.article_description);
        String[] detail = resources.getStringArray(R.array.article_detail);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        for (int i = 0; i < articles.length; i++) {
            images[i] = R.drawable.icon_article;
        }
        articleListAdapter articleListAdapterAdapter = new articleListAdapter(this, articles, description, images, detail);
        listView = findViewById(R.id.articles_list_view);
        listView.setAdapter(articleListAdapterAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Home.this, articlesDetail.class);
                i.putExtra("title", articles[position]);
                i.putExtra("description", description[position]);
                i.putExtra("detail", detail[position]);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_amharic:
                return true;
            case R.id.item_exit:
                exitApp();
                return true;
            case R.id.item_share:
                shareApp();
                return true;
            case R.id.item_about:
                Intent aboutIntent =new Intent(getApplicationContext(),aboutus.class);
                startActivity(aboutIntent);
                return true;
            case R.id.item_contact_us:
                Intent contactIntent =new Intent(getApplicationContext(),Contactus.class);
                startActivity(contactIntent);
                return true;

        }
        return false;
    }

    public void exitApp() {
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
    public void shareApp() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND); // because we sent some txt
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Ethiopian Constitution");
        String shareMessage;
        shareMessage = "https://play.google.com/store/apps/details?id=" + buildConfig.APPLICATION_ID + "\n\n"; // add package name
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        startActivity(Intent.createChooser(shareIntent, "Share Using"));
    }

    }


