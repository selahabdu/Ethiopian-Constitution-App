package com.selah.constitution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class articlesDetail extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_detail);
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

    }
}