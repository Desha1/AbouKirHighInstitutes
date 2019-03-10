package com.example.mostafa.aboukirhighinstitutes;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class SitNo extends AppCompatActivity implements View.OnClickListener, ValueEventListener {


    String getIntent;
    EditText sitNum;
    TextView showAllResults, instituteName;
    Button enterButton;
    boolean haveSitNum = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sit_no);

        defineAllElements();

        if (getIntent.contains("hicis")){
            instituteName.setText("H.I.C.I.S");
        }else if (getIntent.contains("hith")){
            instituteName.setText("H.I.T.H");
        }else if (getIntent.contains("himr")){
            instituteName.setText("H.I.M.R");
        }

        enterButton.setOnClickListener(this);

        showAllResults.setPaintFlags(showAllResults.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        showAllResults.setOnClickListener(this);

    }

    void defineAllElements() {
        getIntent = getIntent().getStringExtra("intent");
        sitNum = findViewById(R.id.sit_num);
        instituteName = findViewById(R.id.institute_name);
        showAllResults = findViewById(R.id.show_all_results);
        enterButton = findViewById(R.id.enter_sit_number);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.enter_sit_number:
                if (String.valueOf(sitNum.getText().toString()).equals("")) {
                    final AlertDialog.Builder aBuilder = new AlertDialog.Builder(SitNo.this);
                    aBuilder.setMessage("Enter your sit Number, and try again!").setCancelable(true);
                    aBuilder.setPositiveButton(
                            "OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    aBuilder.setCancelable(true);
                                }
                            }
                    );
                    aBuilder.setTitle("Invalid number!");
                    aBuilder.show();
                } else if (Long.parseLong(sitNum.getText().toString()) > 99999999) {
                    Toast.makeText(this, "Out of index", Toast.LENGTH_LONG).show();

                } else if (isNetworkConnected()) {
                    intent = new Intent(this, StudentDetails.class);
                    intent.putExtra("intent", getIntent + "SitNo");
                    intent.putExtra("sitNum", sitNum.getText().toString());
                    intent.putExtra("toStudentDetails", "sitNum");
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Please connect to the network", Toast.LENGTH_LONG).show();
                }


                break;

            case R.id.show_all_results:
                if (isNetworkConnected()) {
                    intent = new Intent(this, StudentsList.class);
                    intent.putExtra("intent", getIntent + "SitNo");
                    startActivity(intent);
                    break;
                } else {
                    Toast.makeText(this, "Please connect to the network", Toast.LENGTH_LONG).show();
                }

        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        assert cm != null;
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            Student student = snapshot.getValue(Student.class);
            if (student != null && sitNum.getText().toString().equals(String.valueOf(student.getSitNum()))) {
                haveSitNum = true;
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Toast.makeText(this, "Their is some thing wrong in 'connection'", Toast.LENGTH_LONG).show();
    }
}
