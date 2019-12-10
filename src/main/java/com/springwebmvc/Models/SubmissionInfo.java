package com.springwebmvc.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by motaleb on 7/8/17.
 */
@Entity
public class SubmissionInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String AorL;
    private String Name;
    private int Number;
    private String CourseTitle;
    private String CourseCode;
    private String StudentName;
    private String StudentId;
    private String Dept;
    private String folderName;
    private String pDate;
    private String sDate;
    private String fileName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAorL() {
        return AorL;
    }

    public void setAorL(String aorL) {
        AorL = aorL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        CourseTitle = courseTitle;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "SubmissionInfo{" +
                "id=" + id +
                ", AorL='" + AorL + '\'' +
                ", Name='" + Name + '\'' +
                ", Number=" + Number +
                ", CourseTitle='" + CourseTitle + '\'' +
                ", CourseCode='" + CourseCode + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", StudentId='" + StudentId + '\'' +
                ", Dept='" + Dept + '\'' +
                ", folderName='" + folderName + '\'' +
                ", pDate='" + pDate + '\'' +
                ", sDate='" + sDate + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
