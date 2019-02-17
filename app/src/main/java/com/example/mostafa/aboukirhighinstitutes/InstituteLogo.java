package com.example.mostafa.aboukirhighinstitutes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class InstituteLogo extends AppCompatActivity {

    DatabaseReference database;
    Student student;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_logo);
        database = FirebaseDatabase.getInstance().getReference();
        student = new Student("test", 0, 100, 100, 100, 100, 100);
        setInstitutesToFirebase();

        int secondsDelayed = 2000;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(InstituteLogo.this, InstitutesName.class));
                finish();
            }
        }, secondsDelayed);
    }

    //    Create an Institutes to firebase for a first time
    private void setInstitutesToFirebase() {
        computerAndInformationSystem();
        tourismAndHotels();
        monumentRestoration();
    }

    private void computerAndInformationSystem() {
        //firstYear
        database.child("highInstituteForComputerAndInformationSystem")
                .child("firstYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForComputerAndInformationSystem")
                .child("firstYear").child("secondSemester").child("test").setValue(student);

        //secondYear
        database.child("highInstituteForComputerAndInformationSystem")
                .child("secondYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForComputerAndInformationSystem")
                .child("secondYear").child("secondSemester").child("test").setValue(student);

        //thirdYear
        database.child("highInstituteForComputerAndInformationSystem")
                .child("thirdYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForComputerAndInformationSystem")
                .child("thirdYear").child("secondSemester").child("test").setValue(student);

        //fourthYear
        database.child("highInstituteForComputerAndInformationSystem")
                .child("fourthYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForComputerAndInformationSystem")
                .child("fourthYear").child("secondSemester").child("test").setValue(student);
    }

    private void tourismAndHotels() {
        //firstYear
        database.child("highInstituteForTourismAndHotels")
                .child("firstYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForTourismAndHotels")
                .child("firstYear").child("secondSemester").child("test").setValue(student);

        //secondYear
        database.child("highInstituteForTourismAndHotels")
                .child("secondYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForTourismAndHotels")
                .child("secondYear").child("secondSemester").child("test").setValue(student);

        //thirdYear
        database.child("highInstituteForTourismAndHotels")
                .child("thirdYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForTourismAndHotels")
                .child("thirdYear").child("secondSemester").child("test").setValue(student);

        //fourthYear
        database.child("highInstituteForTourismAndHotels")
                .child("fourthYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForTourismAndHotels")
                .child("fourthYear").child("secondSemester").child("test").setValue(student);
    }

    private void monumentRestoration() {
        //firstYear
        database.child("highInstituteForMonumentRestoration")
                .child("firstYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForMonumentRestoration")
                .child("firstYear").child("secondSemester").child("test").setValue(student);

        //secondYear
        database.child("highInstituteForMonumentRestoration")
                .child("secondYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForMonumentRestoration")
                .child("secondYear").child("secondSemester").child("test").setValue(student);

        //thirdYear
        database.child("highInstituteForMonumentRestoration")
                .child("thirdYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForMonumentRestoration")
                .child("thirdYear").child("secondSemester").child("test").setValue(student);

        //fourthYear
        database.child("highInstituteForMonumentRestoration")
                .child("fourthYear").child("firstSemester").child("test").setValue(student);
        database.child("highInstituteForMonumentRestoration")
                .child("fourthYear").child("secondSemester").child("test").setValue(student);
    }

    private void test() {
        try {
            URL url = new URL("https://www.google.com.eg/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            Log.e("connection",String.valueOf(connection.getResponseCode()));
            if (connection.getResponseCode() == 404) {
                //Log.e("connection",String.valueOf(connection.getResponseCode()));
            }
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            Log.e("invalid url", "invalid url");
        } catch (IOException e) {
            Log.e("connection error", "can not open connection to this url");
        }
    }

}
