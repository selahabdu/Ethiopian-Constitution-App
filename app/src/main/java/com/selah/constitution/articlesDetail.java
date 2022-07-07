package com.selah.constitution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import com.selah.constitution.utils.LanguageConfig;
import com.selah.constitution.utils.SharedPrefs;

public class articlesDetail extends AppCompatActivity {
    Home h;
    SharedPrefs sharedPreferences;
    SeekBar textSizeSeekBar;
    int textSizeValue;
    ListAdapter articleListAdapterAdapter;
    //language preference
    @Override
    protected void attachBaseContext(Context newBase) {
        sharedPreferences = new SharedPrefs(newBase);
        String languageCode = sharedPreferences.getLocale();
        Context context = LanguageConfig.changeLanguage(newBase, languageCode);
        super.attachBaseContext(context);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_detail);
        textSizeSeekBar = findViewById(R.id.textSizeSeekBar);
        Intent intent = getIntent();
        String name = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String detail = intent.getStringExtra("detail");

        TextView article_name,article_description,article_detail;
        article_name = findViewById(R.id.article_layout_title);
        article_description = findViewById(R.id.article_layout_description);
        article_detail = findViewById(R.id.article_layout_detail);

        article_name.setText(name);
        article_description .setText(description);
        article_detail .setText(detail);

        textSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress > 13) {
                    textSizeValue = progress;
                    article_detail.setTextSize(textSizeValue);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
            case R.id.item_amharic:
            {
                sharedPreferences.setLocale("am");
                Intent i  = new Intent(articlesDetail.this,Home.class);
                startActivity(i);
            }
            return true;
            case R.id.item_Enlgish: {
                sharedPreferences.setLocale("en");
                Intent i  = new Intent(articlesDetail.this,Home.class);
                 startActivity(i);
            }
            return true;
            case R.id.item_affan_oromo:{
                sharedPreferences.setLocale("om");
                Intent i  = new Intent(articlesDetail.this,Home.class);
                startActivity(i);
            }
            return true;
            case R.id.item_exit:
                h.exitApp();
                return true;
            case R.id.item_share:
                h.shareApp();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
