package com.example.mostafa.aboukirhighinstitutes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentsList extends AppCompatActivity implements ValueEventListener {

    private ArrayList<Student> studentsList;
    private DatabaseReference database;
    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private String getIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        getIntent = getIntent().getStringExtra("intent");

        defineAllElements();

        checkIntent();

        //On Row item click
        adapter.setStudentDetails(new StudentAdapter.StudentDetails() {
            @Override
            public void onStudent(int position) {
                Student studentData = studentsList.get(position);
                Intent intent = new Intent(StudentsList.this, StudentDetails.class);
                intent.putExtra("studentData", studentData);
                intent.putExtra("intent", "StudentList");
                intent.putExtra("sitNum", "wit");
                startActivity(intent);
            }
        });
    }

    public void defineAllElements() {
        studentsList = new ArrayList<>();
        //put list to the adapter
        adapter = new StudentAdapter(this, studentsList);
        //Define RecyclerView and put adapter in it and set layoutManager
        recyclerView = findViewById(R.id.student_list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        database = FirebaseDatabase.getInstance().getReference();
    }

    public void checkIntent() {
        switchHicis();
        switchHith();
        switchHimr();
    }

    private void switchHicis() {
        switch (getIntent) {
            case "hicisFirstYearFirstSemesterSitNo":
                getHicisFirstYearFirstSemester();
                break;
            case "hicisFirstYearSecondSemesterSitNo":
                getHicisFirstYearSecondSemester();
                break;
            case "hicisSecondYearFirstSemesterSitNo":
                getHicisSecondYearFirstSemester();
                break;
            case "hicisSecondYearSecondSemesterSitNo":
                getHicisSecondYearSecondSemester();
                break;
            case "hicisThirdYearFirstSemesterSitNo":
                getHicisThirdYearFirstSemester();
                break;
            case "hicisThirdYearSecondSemesterSitNo":
                getHicisThirdYearSecondSemester();
                break;
            case "hicisFourthYearFirstSemesterSitNo":
                getHicisFourthYearFirstSemester();
                break;
            case "hicisFourthYearSecondSemesterSitNo":
                getHicisFourthYearSecondSemester();
                break;
        }
    }

    private void switchHith() {
        switch (getIntent) {
            case "hithFirstYearFirstSemesterSitNo":
                getHithFirstYearFirstSemester();
                break;
            case "hithFirstYearSecondSemesterSitNo":
                getHithFirstYearSecondSemester();
                break;
            case "hithSecondYearFirstSemesterSitNo":
                getHithSecondYearFirstSemester();
                break;
            case "hithSecondYearSecondSemesterSitNo":
                getHithSecondYearSecondSemester();
                break;
            case "hithThirdYearFirstSemesterSitNo":
                getHithThirdYearFirstSemester();
                break;
            case "hithThirdYearSecondSemesterSitNo":
                getHithThirdYearSecondSemester();
                break;
            case "hithFourthYearFirstSemesterSitNo":
                getHithFourthYearFirstSemester();
                break;
            case "hithFourthYearSecondSemesterSitNo":
                getHithFourthYearSecondSemester();
                break;
        }
    }

    private void switchHimr() {
        switch (getIntent) {
            case "himrFirstYearFirstSemesterSitNo":
                getHimrFirstYearFirstSemester();
                break;
            case "himrFirstYearSecondSemesterSitNo":
                getHimrFirstYearSecondSemester();
                break;
            case "himrSecondYearFirstSemesterSitNo":
                getHimrSecondYearFirstSemester();
                break;
            case "himrSecondYearSecondSemesterSitNo":
                getHimrSecondYearSecondSemester();
                break;
            case "himrThirdYearFirstSemesterSitNo":
                getHimrThirdYearFirstSemester();
                break;
            case "himrThirdYearSecondSemesterSitNo":
                getHimrThirdYearSecondSemester();
                break;
            case "himrFourthYearFirstSemesterSitNo":
                getHimrFourthYearFirstSemester();
                break;
            case "himrFourthYearSecondSemesterSitNo":
                getHimrFourthYearSecondSemester();
                break;
        }
    }

    //hicis
    public void getHicisFirstYearFirstSemester() {
        database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHicisFirstYearSecondSemester() {
        database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHicisSecondYearFirstSemester() {
        database.child("highInstituteForComputerAndInformationSystem").child("secondYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHicisSecondYearSecondSemester() {
        database.child("highInstituteForComputerAndInformationSystem").child("secondYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHicisThirdYearFirstSemester() {
        database.child("highInstituteForComputerAndInformationSystem").child("thirdYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHicisThirdYearSecondSemester() {
        database.child("highInstituteForComputerAndInformationSystem").child("thirdYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHicisFourthYearFirstSemester() {
        database.child("highInstituteForComputerAndInformationSystem").child("fourthYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHicisFourthYearSecondSemester() {
        database.child("highInstituteForComputerAndInformationSystem").child("fourthYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    //hith
    public void getHithFirstYearFirstSemester() {
        database.child("highInstituteForTourismAndHotels").child("firstYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHithFirstYearSecondSemester() {
        database.child("highInstituteForTourismAndHotels").child("firstYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHithSecondYearFirstSemester() {
        database.child("highInstituteForTourismAndHotels").child("secondYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHithSecondYearSecondSemester() {
        database.child("highInstituteForTourismAndHotels").child("secondYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHithThirdYearFirstSemester() {
        database.child("highInstituteForTourismAndHotels").child("thirdYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHithThirdYearSecondSemester() {
        database.child("highInstituteForTourismAndHotels").child("thirdYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHithFourthYearFirstSemester() {
        database.child("highInstituteForTourismAndHotels").child("fourthYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHithFourthYearSecondSemester() {
        database.child("highInstituteForTourismAndHotels").child("fourthYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    //himr
    public void getHimrFirstYearFirstSemester() {
        database.child("highInstituteForMonumentRestoration").child("firstYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHimrFirstYearSecondSemester() {
        database.child("highInstituteForMonumentRestoration").child("firstYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHimrSecondYearFirstSemester() {
        database.child("highInstituteForMonumentRestoration").child("secondYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHimrSecondYearSecondSemester() {
        database.child("highInstituteForMonumentRestoration").child("secondYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHimrThirdYearFirstSemester() {
        database.child("highInstituteForMonumentRestoration").child("thirdYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHimrThirdYearSecondSemester() {
        database.child("highInstituteForMonumentRestoration").child("thirdYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHimrFourthYearFirstSemester() {
        database.child("highInstituteForMonumentRestoration").child("fourthYear").child("firstSemester")
                .addListenerForSingleValueEvent(this);

    }

    public void getHimrFourthYearSecondSemester() {
        database.child("highInstituteForMonumentRestoration").child("fourthYear").child("secondSemester")
                .addListenerForSingleValueEvent(this);

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            Student student = snapshot.getValue(Student.class);
            studentsList.add(student);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Toast.makeText(StudentsList.this, "Their is some thing wrong in 'connection'", Toast.LENGTH_LONG).show();
    }
}