package com.student.studentService.dao.repository;

import com.student.studentService.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentByRoleId(int roleId);

    List<Student> findStudentsByStudentName(String studentName);

    List<Student> findStudentsByStudentClass(int studentClass);

    Student findTop1StudentByStudentClassOrderByStudentHeightDesc(int studentClass);

}
