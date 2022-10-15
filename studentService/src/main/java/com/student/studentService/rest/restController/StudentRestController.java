package com.student.studentService.rest.restController;

import com.student.studentService.dao.entity.Student;
import com.student.studentService.rest.requestModel.StudentRequest;
import com.student.studentService.rest.responseModel.GeneralResponse;
import com.student.studentService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/studentServices")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public GeneralResponse<List<Student>> getAllStudents() {
        return new GeneralResponse<>(true,"Student List",studentService.getAllStudent());
    }

    @GetMapping("/getAllStudentsByClass/{studentClass}")
    public GeneralResponse<List<Student>> getAllStudentsByClass(@PathVariable int studentClass) {
        return new GeneralResponse<>(true,"Student List",studentService.getAllStudentOfClass(studentClass));
    }

    @GetMapping("/getAllStudentsByName/{studentName}")
    public GeneralResponse<List<Student>> getAllStudentsByName(@PathVariable String studentName) {
        return new GeneralResponse<>(true,"Student List",studentService.getStudentsByName(studentName));
    }

    @GetMapping("/getStudentByStudentId/{studentId}")
    public GeneralResponse<Student> getAllStudentsByStudentId(@PathVariable int studentId) {
        return new GeneralResponse<>(true,"Student List",studentService.getStudentById(studentId));
    }

    @GetMapping("/getTallestStudentsByClass/{studentClass}")
    public GeneralResponse<Student> getTallestStudentsByClass(@PathVariable int studentClass) {
        return new GeneralResponse<>(true,"Tallest Student",studentService.getTallestStudentOfClass(studentClass));
    }

    @PostMapping("/addStudents")
    public GeneralResponse<Student> addStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return new GeneralResponse<>(true,"Student List",studentService.addStudent(studentRequest));
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public GeneralResponse<Void> addStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return new GeneralResponse<Void>(true,"Student List",null);
    }

}
