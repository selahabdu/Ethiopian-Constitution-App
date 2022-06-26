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

    //try declaring the articles using loop
//    String[] articles = getResources().getStringArray(R.array.article_names);
    String[] articles={
            //try to declare with loop
            "Article 1",
            "Article 2",
//            "Article 3",
//            "Article 4",
//            "Article 5",
//            "Article 6",
//            "Article 7",
//            "Article 8",
//            "Article 9",
//            "Article 10",
//            "Article 11",
    };
    String[] description = {
            "Nomenclature of the State",
            "Ethiopian Territorial Jurisdiction",
//            "The Ethiopian Flag",
//            "National Anthem of Ethiopia",
//            "Languages",
//            "Nationality",
//            "Gender Reference",
//            "Sovereignty of the People",
//            "Supremacy of the Constitution",
//            "Human and Democratic Rights",
//            "Separation of State and Religion"


    };
    String[] detail = {
            "This Constitution establishes a Federal and Democratic State structure. Accordingly, the Ethiopian state.shall be known as The Federal Democratic Republic of Ethiopia.",
            "The territorial jurisdiction of Ethiopia shall comprise the territory of the members of the Federation and its boundaries shall be as determined by international agreements."
    };
    private Integer[] images = new Integer[14];

    {
//    private Integer[] images = {
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article,
//            R.drawable.icon_article
//    };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      for(int i=0;i<articles.length;i++){

            images[i] = R.drawable.icon_article;
        }
//        int j = 1;
//        for(int i=0;i<12;i++){

//            articles[i] ="Article";
//            j++;
//        }

        articleListAdapter articleListAdapterAdapter = new articleListAdapter(this,articles,description,images,detail);

        listView = findViewById(R.id.articles_list_view);
        listView.setAdapter(articleListAdapterAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i  = new Intent(Home.this,articlesDetail.class);
                i.putExtra("title",articles[position]);
                i.putExtra("description",description[position]);
                i.putExtra("detail",detail[position]);

                startActivity(i);
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