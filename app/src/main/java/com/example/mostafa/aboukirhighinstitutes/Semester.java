package com.example.mostafa.aboukirhighinstitutes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Semester extends AppCompatActivity implements View.OnClickListener {

    Button firstSemester, secondSemester;
    String getIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        getIntent = getIntent().getStringExtra("intent");
        defineAllElements();
    }

    public void defineAllElements() {
        firstSemester = findViewById(R.id.first_semester);
        secondSemester = findViewById(R.id.second_semester);

        firstSemester.setOnClickListener(this);
        secondSemester.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SitNo.class);
        switch (v.getId()) {

            case R.id.first_semester:

                intent.putExtra("intent", getIntent + "FirstSemester");
                startActivity(intent);
                break;

            case R.id.second_semester:
                intent.putExtra("intent", getIntent + "SecondSemester");
                startActivity(intent);
                break;
        }
    }
}
