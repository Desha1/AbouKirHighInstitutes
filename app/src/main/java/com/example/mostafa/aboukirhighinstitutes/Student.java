package com.example.mostafa.aboukirhighinstitutes;


import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private int sitNum, totalSum;
    private int sub1, sub2, sub3, sub4, sub5, sub6;
    private String subGrade1, subGrade2, subGrade3, subGrade4, subGrade5, subGrade6;
    private String totalGrade;
    private int percentage;

    public Student() {
    }

    Student(String name, int sitNum, int sub1, int sub2, int sub3, int sub4, int sub5, int sub6) {
        this.name = name;
        this.sitNum = sitNum;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = sub6;
        setSubGrade1();
        setSubGrade2();
        setSubGrade3();
        setSubGrade4();
        setSubGrade5();
        setSubGrade6();

        setTotalSum();
        setPercentage();
        setTotalGrade();
    }

    Student(String name, int sitNum, int sub1, int sub2, int sub3, int sub4, int sub5) {
        this.name = name;
        this.sitNum = sitNum;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = -1;
        setSubGrade1();
        setSubGrade2();
        setSubGrade3();
        setSubGrade4();
        setSubGrade5();
        setSubGrade6();

        setTotalSum();
        setPercentage();
        setTotalGrade();
    }

    private void setTotalSum() {
        if (sub6 == -1) {
            this.totalSum = sub1 + sub2 + sub3 + sub4 + sub5;
        } else
            this.totalSum = sub1 + sub2 + sub3 + sub4 + sub5 + sub6;
    }

    private void setTotalGrade() {
        if (this.percentage >= 85) {
            this.totalGrade = "Excellent";
        } else if (this.percentage >= 75) {
            this.totalGrade = "V.Good";
        } else if (this.percentage >= 65) {
            this.totalGrade = "Good";
        } else if (this.percentage >= 50) {
            this.totalGrade = "Accepted";
        } else if (this.percentage < 49.9) {
            this.totalGrade = "Poor";
        }
    }

    private void setPercentage() {
        if (sub6 == -1)
            this.percentage = this.totalSum / 5;
        else
            this.percentage = this.totalSum / 6;
    }

    private String getGrade(int subjectScore) {
        String grade;
        if (subjectScore >= 85) {
            grade = "Excellent";
        } else if (subjectScore >= 75) {
            grade = "V.Good";
        } else if (subjectScore >= 65) {
            grade = "Good";
        } else if (subjectScore >= 50) {
            grade = "Accepted";
        } else if (subjectScore <= 49.9) {
            grade = "Poor";
        } else grade = "";

        return grade;
    }

    private void setSubGrade1() {
        this.subGrade1 = getGrade(sub1);
    }

    private void setSubGrade2() {
        this.subGrade2 = getGrade(sub2);
    }

    private void setSubGrade3() {
        this.subGrade3 = getGrade(sub3);
    }

    private void setSubGrade4() {
        this.subGrade4 = getGrade(sub4);
    }

    private void setSubGrade5() {
        this.subGrade5 = getGrade(sub5);
    }

    private void setSubGrade6() {
        if (sub6 == -1)
            this.subGrade6 = null;
        else
            this.subGrade6 = getGrade(sub6);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSitNum(int sitNum) {
        this.sitNum = sitNum;
    }

    public void setSub1(int sub1) {
        this.sub1 = sub1;
    }

    public void setSub2(int sub2) {
        this.sub2 = sub2;
    }

    public void setSub3(int sub3) {
        this.sub3 = sub3;
    }

    public void setSub4(int sub4) {
        this.sub4 = sub4;
    }

    public void setSub5(int sub5) {
        this.sub5 = sub5;
    }

    public void setSub6(int sub6) {
        this.sub6 = sub6;
    }

    public String getName() {
        return name;
    }

    public int getSitNum() {
        return sitNum;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public int getSub1() {
        return sub1;
    }

    public int getSub2() {
        return sub2;
    }

    public int getSub3() {
        return sub3;
    }

    public int getSub4() {
        return sub4;
    }

    public int getSub5() {
        return sub5;
    }

    public int getSub6() {
        return sub6;
    }

    public String getSubGrade1() {
        return subGrade1;
    }

    public String getSubGrade2() {
        return subGrade2;
    }

    public String getSubGrade3() {
        return subGrade3;
    }

    public String getSubGrade4() {
        return subGrade4;
    }

    public String getSubGrade5() {
        return subGrade5;
    }

    public String getSubGrade6() {
        return subGrade6;
    }

    public String getTotalGrade() {
        return totalGrade;
    }

    public int getPercentage() {
        return percentage;
    }
}
