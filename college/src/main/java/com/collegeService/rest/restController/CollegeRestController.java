package com.collegeService.rest.restController;

import com.collegeService.clients.StudentServiceProxy;
import com.collegeService.rest.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collegeService")
public class CollegeRestController {

    @Autowired
    private StudentServiceProxy studentServiceProxy;

    @GetMapping("/getStudent/{studentId}")
    public Object getStudentById(@PathVariable int studentId) {
        try {
            Object response = studentServiceProxy.getStudentById(studentId);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"Failed in calling student service",null);
        }
    }
}
