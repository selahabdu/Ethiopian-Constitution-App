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
            "Article 3",
            "Article 4",
            "Article 5",
            "Article 6",
            "Article 7",
            "Article 8",
            "Article 9",
            "Article 10",
            "Article 11",
            "Article 12",
            "Article 13"
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
            "Separation of State and Religion",
            "Conduct and Accountability of Government",
            "Scope of Application and Interpretation"


    };
    String[] detail = {
            "This Constitution establishes a Federal and Democratic State structure. Accordingly, the Ethiopian state.shall be known as The Federal Democratic Republic of Ethiopia.",
            "The territorial jurisdiction of Ethiopia shall comprise the territory of the members of the Federation and its boundaries shall be as determined by international agreements.",
            "1. The Ethiopian flag shall consist of green at the top, yellow in the middle and red at the bottom, and shall have a national emblem at the centre. The three colours shall be set horizontally in equal dimension\n" +
            "2. The national emblem on the flag shall reflect the hope of the Nations, Nationalities, Peoples as well as religious communities of Ethiopia to live together in equality and unity.\n" +
            "3. Members of the Federation may have their respective flags and emblems and shall determine the details thereof through their respective legislatures.",
            "The national anthem of Ethiopia, to be determined by law, shall reflect the ideals of the Constitution, the commitment of the Peoples of Ethiopia to live together in a democratic order and of their common destiny",
            "1. All Ethiopian languages shall enjoy equal state recognition\n2. Amharic shall be the working language of the Federal Government.\n3. Members of the Federation may by law determine their respective working languages",
            "1. Any person of either sex shall be an Ethiopian national where both or either parent is Ethiopian\n2. Foreign nationals may acquire Ethiopian nationality.\n3. Particulars relating to nationality shall be determined by law",
            "Provisions of this Constitution set out in the masculine gender shall also apply to the feminine gender.",
            "All sovereign power resides in the Nations, Nationalities and Peoples of Ethiopia.\n2. This Constitution is an expression of their sovereignty.3. Their sovereignty shall be expressed through their representatives elected in accordance with this Constitution and through their direct democratic participation.",
            "1. The Constitution is the supreme law of the land. Any law customary practice or a decision of an organ of state or a public official which contravenes this Constitution shall be of no effect.\n2. All citizens, organs of state, political organizations, other associations as well as their officials have the duty to ensure observance of the Constitution and to obey it.\n3. It is prohibited to assume state power in any manner other than that provided under the Constitution.\n4. All international agreements ratified by Ethiopia are an integral part of the law of the land.",
            "1. Human rights and freedoms, emanating from the nature of mankind, are inviolable and inalienable.\n2. Human and democratic rights of citizens and peoples shall be respected",
            "1. State and religion are separate.\n2. There shall be no state religion.\n3. The state shall not interfere in religious matters and religion shall not interfere in state affairs.",
            "1. The conduct of affairs of government shall be transparent.\n2. Any public official or an elected representative is accountable for any failure in official duties.\n3. In case of loss of confidence, the people may recall an elected representative. The particulars of recall shall be determined by law.",
            "1. All Federal and State legislative, executive and judicial organs at all levels shall have the responsibility and duty to respect and enforce the provisions of this Chapter.\n" +
             "2. The fundamental rights and freedoms specified in this Chapter shall be interpreted in a manner conforming to the principles of the Universal Declaration of Human Rights, International Covenants on Human Rights and international instruments adopted by Ethiopia.\n"
  };

    private Integer[] images = new Integer[14];
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