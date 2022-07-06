package com.selah.constitution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import com.selah.constitution.utils.LanguageConfig;
import com.selah.constitution.utils.SharedPrefs;

public class articlesDetail extends AppCompatActivity {
    Home h;
    SharedPrefs sharedPreferences;
    SeekBar textSizeSeekBar;
    int textSizeValue;
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
//        Resources resources = getResources();
//        String[] articles= resources.getStringArray(R.array.article_names);
//        String[] description = resources.getStringArray(R.array.article_description);
//        String[] detail = resources.getStringArray(R.array.article_detail);
//
//        String[] articles_am= resources.getStringArray(R.array.article_names_am);
//        String[] description_am = resources.getStringArray(R.array.article_description_am);
//        String[] detail_am = resources.getStringArray(R.array.article_detail_am);
        switch (item.getItemId()){
            case R.id.item_search:
            {
//                SearchView searchView = (SearchView) item.getActionView();
//                searchView.setQueryHint("Search article");
//                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                    @Override
//                    public boolean onQueryTextSubmit(String query) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onQueryTextChange(String newText) {
////                        articles.getFilter().filter(newText);
//                        return false;
//                    }
//                });
            }
            case R.id.item_amharic:
            {
                sharedPreferences.setLocale("am");
                articlesDetail.this.recreate();

                //                articleListAdapterAdapter = new articleListAdapter(this,articles_am,description_am,images,detail_am);
//                listView = findViewById(R.id.articles_list_view);
//                listView.setAdapter(articleListAdapterAdapter);
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent i  = new Intent(Home.this,articlesDetail.class);
//                        i.putExtra("title",articles_am[position]);
//                        i.putExtra("description",description_am[position]);
//                        i.putExtra("detail",detail_am[position]);
//                        startActivity(i);
//                    }
//                });
            }
            return true;
            case R.id.item_Enlgish: {
                sharedPreferences.setLocale("en");
                articlesDetail.this.recreate();
//                Intent intent = new Intent(getApplicationContext(),Home.class);
//                startActivity(intent);



//                articleListAdapterAdapter = new articleListAdapter(this, articles, description, images, detail);
//                listView = findViewById(R.id.articles_list_view);
//                listView.setAdapter(articleListAdapterAdapter);
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent i = new Intent(Home.this, articlesDetail.class);
//                        i.putExtra("title", articles[position]);
//                        i.putExtra("description", description[position]);
//                        i.putExtra("detail", detail[position]);
//                        startActivity(i);
//                    }
//                });
            }
            case R.id.item_affan_oromo:{
                sharedPreferences.setLocale("om");
                articlesDetail.this.recreate();

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
