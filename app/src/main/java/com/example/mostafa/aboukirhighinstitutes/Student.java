package com.example.mostafa.aboukirhighinstitutes;


import java.io.Serializable;

public class Student implements Serializable {

    //Reference to student name
    private String name;
    private int sitNum, totalSum;

    //Reference to subject grade
    private String subGrade1, subGrade2, subGrade3, subGrade4, subGrade5, subGrade6, subGrade7, subGrade8;
    //Reference to subject name
    private String subName1, subName2, subName3, subName4, subName5, subName6, subName7, subName8;

    private String totalGrade;
    private int percentage;

    Student() {}

    public String getName() {
        return name;
    }

    int getSitNum() {
        return sitNum;
    }

    int getTotalSum() {
        return totalSum;
    }

    String getSubName1() {
        return subName1;
    }

    String getSubName2() {
        return subName2;
    }

    String getSubName3() {
        return subName3;
    }

    String getSubName4() {
        return subName4;
    }

    String getSubName5() {
        return subName5;
    }

    String getSubName6() {
        return subName6;
    }

    String getSubName7() {
        return subName7;
    }

    String getSubName8() {
        return subName8;
    }

    String getSubGrade1() {
        return subGrade1;
    }

    String getSubGrade2() {
        return subGrade2;
    }

    String getSubGrade3() {
        return subGrade3;
    }

    String getSubGrade4() {
        return subGrade4;
    }

    String getSubGrade5() {
        return subGrade5;
    }

    String getSubGrade6() {
        return subGrade6;
    }

    String getSubGrade7() {
        return subGrade7;
    }

    String getSubGrade8() {
        return subGrade8;
    }

    String getTotalGrade() {
        return this.totalGrade;
    }

    int getPercentage() {
        return this.percentage;
    }
}
