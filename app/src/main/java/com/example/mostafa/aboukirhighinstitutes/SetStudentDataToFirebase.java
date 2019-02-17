package com.example.mostafa.aboukirhighinstitutes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetStudentDataToFirebase extends AppCompatActivity implements View.OnClickListener {

    EditText sitNumber, studentName, sub1, sub2, sub3, sub4, sub5, sub6;
    Button enterData;
    DatabaseReference database;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_student_data_to_firebase);

        defineAllElements();

    }

    private void defineAllElements() {
        sitNumber = findViewById(R.id.sit_num);
        studentName = findViewById(R.id.student_name);
        sub1 = findViewById(R.id.sub1);
        sub2 = findViewById(R.id.sub2);
        sub3 = findViewById(R.id.sub3);
        sub4 = findViewById(R.id.sub4);
        sub5 = findViewById(R.id.sub5);
        sub6 = findViewById(R.id.sub6);
        enterData = findViewById(R.id.enter_data);
        enterData.setOnClickListener(this);

        database = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View v) {
        //Log.e("sub6 value",sub6.getText().toString());
        if (sub6.getText().toString().equals("")) {
            Log.e("condition", "in");
            student = new Student(studentName.getText().toString(), Integer.parseInt(sitNumber.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()));
        } else {
            Log.e("condition", "out");
            Log.e("sub6Value", sub6.getText().toString());
            student = new Student(studentName.getText().toString(), Integer.parseInt(sitNumber.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        }
        Log.e("sub6 value", sub6.getText().toString());
        setFirebaseStudent(student, sitNumber.getText().toString());
    }

    void setFirebaseStudent(Student student, String sitNum) {
        database.child("highInstituteForComputerAndInformationSystem")
                .child("firstYear").child("firstSemester").child(sitNum).setValue(student);
    }
}
