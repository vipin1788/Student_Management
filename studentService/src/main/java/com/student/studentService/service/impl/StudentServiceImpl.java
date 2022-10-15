package com.student.studentService.service.impl;

import com.student.studentService.dao.entity.Student;
import com.student.studentService.dao.repository.StudentRepository;
import com.student.studentService.exception.BadRequestException;
import com.student.studentService.rest.requestModel.StudentRequest;
import com.student.studentService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        try{
            return studentRepository.findAll();
        } catch(Exception e) {
            throw e;
        }

    }

    @Override
    public List<Student> getAllStudentOfClass(int studentClass) {
        try{
            List<Student> students = studentRepository.findStudentsByStudentClass(studentClass);
            return students;
        } catch(Exception e) {
            throw e;
        }

    }

    @Override
    public List<Student> getStudentsByName(String name) {
        try{
            List<Student> students = studentRepository.findStudentsByStudentName(name);
            return students;
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            return studentRepository.findStudentByRoleId(studentId);
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public Student getTallestStudentOfClass(int studentClass) {
        try{
            return studentRepository.findTop1StudentByStudentClassOrderByStudentHeightDesc(studentClass);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        try{
            Student student = new Student();
            student.setStudentName(studentRequest.getStudentName());
            student.setStudentClass(studentRequest.getStudentClass());
            student.setStudentHeight(studentRequest.getStudentHeight());
            return studentRepository.save(student);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        try{
            Student student = studentRepository.findStudentByRoleId(studentId);
            if(student == null) {
                throw new BadRequestException("Record does not exist");
            }
            studentRepository.delete(student);
        } catch (Exception e){
            throw e;
        }
    }
}
