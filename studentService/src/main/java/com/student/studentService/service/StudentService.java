package com.student.studentService.service;

import com.student.studentService.dao.entity.Student;
import com.student.studentService.rest.requestModel.StudentRequest;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    List<Student> getAllStudentOfClass(final int studentClass);

    List<Student> getStudentsByName(final String name);

    Student getStudentById(final int studentId);

    Student getTallestStudentOfClass(final int studentClass);

    Student addStudent(final StudentRequest studentRequest);

    void deleteStudent(final int studentId);
}
