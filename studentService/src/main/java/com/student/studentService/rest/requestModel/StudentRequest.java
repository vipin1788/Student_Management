package com.student.studentService.rest.requestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class StudentRequest {

    @NotEmpty(message = "Student name can not be empty")
    @NotNull(message = "Student name can not be null")
    @JsonProperty(value="studentName")
    private String studentName;

    @NotNull(message = "Student class can not be null")
    @JsonProperty(value="studentClass")
    private int studentClass;

    @NotNull(message = "Student Height can not be null")
    @JsonProperty(value="studentHeight")
    private int studentHeight;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public int getStudentHeight() {
        return studentHeight;
    }

    public void setStudentHeight(int studentHeight) {
        this.studentHeight = studentHeight;
    }
}
