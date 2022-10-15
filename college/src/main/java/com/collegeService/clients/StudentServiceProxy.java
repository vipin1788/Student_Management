package com.collegeService.clients;

import com.collegeService.rest.response.Response;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="student-service")
@RibbonClient(name="student-service")
public interface StudentServiceProxy {

    @GetMapping("/studentServices/getStudentByStudentId/{studentId}")
    public Object getStudentById(@PathVariable int studentId);





}
