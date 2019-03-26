package com.lecture.gl.week8fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.security.auth.Destroyable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void switchToDetail(View view){
        int btn_id = view.getId();
        Intent detailIntent = new Intent(this, CharDetailActivity.class);
        switch (btn_id){
            case R.id.balbabtn:
                detailIntent.putExtra("pokeman_name", "balba");
                detailIntent.putExtra("pokeman_img", R.drawable.balba);
                break;
            case R.id.pikabtn:
                detailIntent.putExtra("pokeman_name", "pika");
                detailIntent.putExtra("pokeman_img", getResources().getIdentifier("balba","drawable", getPackageName()));
                break;
            case R.id.saydekbtn:
                detailIntent.putExtra("pokeman_name", "saydek");
                detailIntent.putExtra("pokeman_img", R.drawable.saydek);
                break;
            case R.id.squrtlebtn:
                detailIntent.putExtra("pokeman_name", "squrtle");
                detailIntent.putExtra("pokeman_img", R.drawable.squrtle);
                break;
                default:
                    Toast.makeText(this, R.string.not_supported, Toast.LENGTH_SHORT).show();
        }

        //swicth to second Activity
        startActivity(detailIntent);

    }*/
}
