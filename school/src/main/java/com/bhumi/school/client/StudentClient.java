package com.bhumi.school.client;

import com.bhumi.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students.url}")
public interface StudentClient {

    @GetMapping("/school/{schoolId}")
    List<Student> findAllBySchoolId(@PathVariable Integer schoolId);
}