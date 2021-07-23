package com.example.soschallengeproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recommendation_page extends AppCompatActivity {

    Button rec1,rec2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation_page);
        rec1 = (Button)findViewById(R.id.rec1);
        rec2 = (Button)findViewById(R.id.rec2);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setTitle("Recommendations for You");
        }
    }

    public void Rec1BtnPress(View view) { //when the menu button gets pressed
        Intent YHintent = new Intent(Recommendation_page.this, YardHouseInfoPage.class);
        startActivity(YHintent);
    }
}
