package com.example.mostafa.aboukirhighinstitutes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SitNo extends AppCompatActivity implements View.OnClickListener {


    String getIntent;
    EditText sitNum;
    TextView showAllResults;
    Button enterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sit_no);

        defineAllElements();

        enterButton.setOnClickListener(this);

        showAllResults.setPaintFlags(showAllResults.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        showAllResults.setOnClickListener(this);

    }

    void defineAllElements(){
        getIntent = getIntent().getStringExtra("intent");
        sitNum = findViewById(R.id.sit_num);
        showAllResults = findViewById(R.id.show_all_results);
        enterButton = findViewById(R.id.enter_sit_number);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){

            case R.id.enter_sit_number:
                if (isConnected(this)){
                    intent = new Intent(this,StudentDetails.class);
                    intent.putExtra("intent",getIntent+"SitNo");
                    intent.putExtra("sitNum",sitNum.getText().toString());
                    startActivity(intent);
                }else {
                    Toast.makeText(this,"Please connect to the network",Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.show_all_results:
                intent = new Intent(this,StudentsList.class);
                intent.putExtra("intent",getIntent+"SitNo");
                startActivity(intent);
                break;
        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        assert cm != null;
        return cm.getActiveNetworkInfo() != null;
    }

    public boolean isInternetAvailable() {
        try {
            final InetAddress address = InetAddress.getByName("https://www.google.com.eg/");
            return !address.equals("");
        } catch (UnknownHostException e) {
            Toast.makeText(this,"Please connect to the network",Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager)context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            try {
                URL url = new URL("https://www.google.com/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                if (connection.getResponseCode() == 200) {
                    return true;
                }
            } catch (MalformedURLException e) {
                //e.printStackTrace();
                Log.e("invalid url","invalid url");
            } catch (IOException e) {
                Log.e("connection error","can not open connection to this url");
            }
        }
        return false;
    }
}
