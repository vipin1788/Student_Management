package com.student.studentService.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", initialValue=4, allocationSize=100)
    private int roleId;

    @Column(name="student_name")
    private String studentName;

    @Column(name="student_class")
    private int studentClass;

    @Column(name="student_height")
    private int studentHeight;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

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
