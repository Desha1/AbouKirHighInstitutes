package com.example.mostafa.aboukirhighinstitutes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EducationalYears extends AppCompatActivity implements View.OnClickListener {

    TextView firstYear, secondYear, thirdYear, fourthYear;
    String getIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_years);
        getIntent = getIntent().getStringExtra("intent");

        defineAllElements();
    }

    public void defineAllElements() {
        firstYear = findViewById(R.id.first_year);
        secondYear = findViewById(R.id.second_year);
        thirdYear = findViewById(R.id.third_year);
        fourthYear = findViewById(R.id.fourth_year);
        firstYear.setOnClickListener(this);
        secondYear.setOnClickListener(this);
        thirdYear.setOnClickListener(this);
        fourthYear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Semester.class);
        switch (v.getId()) {

            case R.id.first_year:
                intent.putExtra("intent", getIntent + "FirstYear");
                startActivity(intent);
                break;

            case R.id.second_year:
                intent.putExtra("intent", getIntent + "SecondYear");
                startActivity(intent);
                break;

            case R.id.third_year:
                intent.putExtra("intent", getIntent + "ThirdYear");
                startActivity(intent);
                break;

            case R.id.fourth_year:
                intent.putExtra("intent", getIntent + "FourthYear");
                startActivity(intent);
                break;
        }

    }
}
