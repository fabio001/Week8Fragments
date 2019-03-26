package com.lecture.gl.week8fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CharDetailActivity extends AppCompatActivity {

    private  TextView txt_pName, txt_pDetails;
    private ImageView img_poke;
    private String detail_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_detail);


        txt_pName = findViewById(R.id.txt_poke_name);
        txt_pDetails = findViewById(R.id.txt_poke_detail);
        img_poke = findViewById(R.id.img_poke_img);

        Intent incoming_intent = getIntent();

        if(incoming_intent!=null){
            String poke_name = incoming_intent.getStringExtra("pokeman_name");
            int poke_img_id = incoming_intent.getIntExtra("pokeman_img", -1);

            if(poke_img_id == -1)
                return;

            txt_pName.setText(poke_name);
            img_poke.setImageResource(poke_img_id);

        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //connect internet to get details
                try {
                    Document doc =
                            Jsoup.connect("https://www.ranker.com/review/pikachu/1803710?ref=node_name&pos=6&a=0&ltype=n&l=1704638&g=1").get();
                    //Log.d("Details", doc.text());
                    Element element = doc.selectFirst("#node__bioWikiText");
                    detail_text = element.text();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txt_pDetails.setText(detail_text);
                        }
                    });


                } catch (IOException e){
                    Log.d("Details", e.getLocalizedMessage());
                }
            }
        });

        t.start();

    }
}
