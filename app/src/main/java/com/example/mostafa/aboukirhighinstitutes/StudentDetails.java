package com.example.mostafa.aboukirhighinstitutes;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class StudentDetails extends AppCompatActivity {

    LinearLayout root;
    ProgressBar progressBar;
    ConstraintLayout lastSub;
    TextView studentName, subject1, subject2, subject3, subject4, subject5, subject6, totalAppreciation, sitNum, totalSum, percentage;
    Student studentData;
    String getIntent;
    private String getIntentSitNum;
    private DatabaseReference database;
    private Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        getIntent = getIntent().getStringExtra("intent");
        getIntentSitNum = getIntent().getStringExtra("sitNum");

        // Define All Elements
        defineAllElements();

        checkIntentAndPutDataInElements();

    }

    private void defineAllElements() {
        // Define All Elements
        root = findViewById(R.id.root);
        root.setVisibility(View.GONE);
        progressBar = findViewById(R.id.progress_bar);
        lastSub = findViewById(R.id.last_subject_layout);
        studentName = findViewById(R.id.student_name);
        sitNum = findViewById(R.id.sit_num);
        subject1 = findViewById(R.id.sub1);
        subject2 = findViewById(R.id.sub2);
        subject3 = findViewById(R.id.sub3);
        subject4 = findViewById(R.id.sub4);
        subject5 = findViewById(R.id.sub5);
        subject6 = findViewById(R.id.sub6);
        totalAppreciation = findViewById(R.id.total_appreciation);
        totalSum = findViewById(R.id.total_sum);
        percentage = findViewById(R.id.percent);
        //End Of Define All Elements
        database = FirebaseDatabase.getInstance().getReference();
    }

    private void checkIntentAndPutDataInElements() {


        switch (getIntent) {

            //HICIS
            case "hicisFirstYearFirstSemesterSitNo":
                getDataFromDBFromHicisFirstYearFirstSemester();
                break;
            case "hicisFirstYearSecondSemesterSitNo":
                getDataFromDBFromHicisFirstYearSecondSemester();
                break;
            case "hicisSecondYearFirstSemesterSitNo":
                getDataFromDBFromHicisSecondYearFirstSemester();
                break;
            case "hicisSecondYearSecondSemesterSitNo":
                getDataFromDBFromHicisSecondYearSecondSemester();
                break;
            case "hicisThirdYearFirstSemesterSitNo":
                getDataFromDBFromHicisThirdYearFirstSemester();
                break;
            case "hicisThirdYearSecondSemesterSitNo":
                getDataFromDBFromHicisThirdYearSecondSemester();
                break;
            case "hicisFourthYearFirstSemesterSitNo":
                getDataFromDBFromHicisFourthYearFirstSemester();
                break;
            case "hicisFourthYearSecondSemesterSitNo":
                getDataFromDBFromHicisFourthYearSecondSemester();
                break;

            //HITH
            case "hithFirstYearFirstSemesterSitNo":
                getDataFromDBFromHithFirstYearFirstSemester();
                break;
            case "hithFirstYearSecondSemesterSitNo":
                getDataFromDBFromHithFirstYearSecondSemester();
                break;
            case "hithSecondYearFirstSemesterSitNo":
                getDataFromDBFromHithSecondYearFirstSemester();
                break;
            case "hithSecondYearSecondSemesterSitNo":
                getDataFromDBFromHithSecondYearSecondSemester();
                break;
            case "hithThirdYearFirstSemesterSitNo":
                getDataFromDBFromHithThirdYearFirstSemester();
                break;
            case "hithThirdYearSecondSemesterSitNo":
                getDataFromDBFromHithThirdYearSecondSemester();
                break;
            case "hithFourthYearFirstSemesterSitNo":
                getDataFromDBFromHithFourthYearFirstSemester();
                break;
            case "hithFourthYearSecondSemesterSitNo":
                getDataFromDBFromHithFourthYearSecondSemester();
                break;

            //HIMR
            case "himrFirstYearFirstSemesterSitNo":
                getDataFromDBFromHimrFirstYearFirstSemester();
                break;
            case "himrFirstYearSecondSemesterSitNo":
                getDataFromDBFromHimrFirstYearSecondSemester();
                break;
            case "himrSecondYearFirstSemesterSitNo":
                getDataFromDBFromHimrSecondYearFirstSemester();
                break;
            case "himrSecondYearSecondSemesterSitNo":
                getDataFromDBFromHimrSecondYearSecondSemester();
                break;
            case "himrThirdYearFirstSemesterSitNo":
                getDataFromDBFromHimrThirdYearFirstSemester();
                break;
            case "himrThirdYearSecondSemesterSitNo":
                getDataFromDBFromHimrThirdYearSecondSemester();
                break;
            case "himrFourthYearFirstSemesterSitNo":
                getDataFromDBFromHimrFourthYearFirstSemester();
                break;
            case "himrFourthYearSecondSemesterSitNo":
                getDataFromDBFromHimrFourthYearSecondSemester();
                break;

            default:
                // Get Data From Student List
                getDataFromStudentList();
        }

    }

    private void query() {
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        progressBar.setVisibility(View.GONE);
                        root.setVisibility(View.VISIBLE);
                        studentData = snapshot.getValue(Student.class);
                        if (studentData != null) {
                            lastSubjectFoundCondition();
                            studentName.setText(studentData.getName());
                            sitNum.setText(String.valueOf(studentData.getSitNum()));

                            subject1.setText(String.valueOf(studentData.getSubGrade1()));
                            subject2.setText(studentData.getSubGrade2());
                            subject3.setText(studentData.getSubGrade3());
                            subject4.setText(studentData.getSubGrade4());
                            subject5.setText(studentData.getSubGrade5());
                            subject6.setText(studentData.getSubGrade6());

                            totalAppreciation.setText(studentData.getTotalGrade());
                            totalSum.setText(String.valueOf(studentData.getTotalSum()));
                            percentage.setText(String.format("%s%%", String.valueOf(studentData.getPercentage())));
                        } else {
                            Toast.makeText(StudentDetails.this,
                                    "Can't find this sit Number, please check and try again!", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    final AlertDialog.Builder aBuilder = new AlertDialog.Builder(StudentDetails.this);
                    aBuilder.setMessage("Invalid sit Number, \nplease check and try again!").setCancelable(false);
                    aBuilder.setPositiveButton(
                            "OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }
                    );
                    aBuilder.setTitle("Invalid number!");
                    aBuilder.show();
                    Toast.makeText(StudentDetails.this,
                            "Invalid sit Number, please check and try again!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //HICIS
    private void getDataFromDBFromHicisFirstYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHicisFirstYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHicisSecondYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHicisSecondYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHicisThirdYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHicisThirdYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHicisFourthYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHicisFourthYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    //HITH
    private void getDataFromDBFromHithFirstYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHithFirstYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHithSecondYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHithSecondYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHithThirdYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHithThirdYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHithFourthYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHithFourthYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    //HIMR
    private void getDataFromDBFromHimrFirstYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHimrFirstYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHimrSecondYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHimrSecondYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHimrThirdYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHimrThirdYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHimrFourthYearFirstSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }

    private void getDataFromDBFromHimrFourthYearSecondSemester() {
        query = database.child("highInstituteForComputerAndInformationSystem").child("firstYear").child("firstSemester").orderByChild("sitNum").
                equalTo(Integer.parseInt(getIntentSitNum));
        query();
    }


    private void getDataFromStudentList() {
        progressBar.setVisibility(View.GONE);
        root.setVisibility(View.VISIBLE);
        // Get Data From Student List
        studentData = (Student) getIntent().getSerializableExtra("studentData");

        lastSubjectFoundCondition();
        studentName.setText(studentData.getName());
        sitNum.setText(String.valueOf(studentData.getSitNum()));

        subject1.setText(String.valueOf(studentData.getSubGrade1()));
        subject2.setText(String.valueOf(studentData.getSubGrade2()));
        subject3.setText(String.valueOf(studentData.getSubGrade3()));
        subject4.setText(String.valueOf(studentData.getSubGrade4()));
        subject5.setText(String.valueOf(studentData.getSubGrade5()));
        subject6.setText(String.valueOf(studentData.getSubGrade6()));

        totalAppreciation.setText(studentData.getTotalGrade());
        totalSum.setText(String.valueOf(studentData.getTotalSum()));
        percentage.setText(String.format("%s%%", String.valueOf(studentData.getPercentage())));
    }

    private void lastSubjectFoundCondition() {
        if (studentData.getSubGrade6() == null) {
            lastSub.removeAllViews();
        }
    }
}
