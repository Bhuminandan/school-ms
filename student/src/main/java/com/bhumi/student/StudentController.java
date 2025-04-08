package com.bhumi.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Student student
    ) {
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> findAllStudentsBySchool(
            @PathVariable Integer schoolId
    ) {
        return new ResponseEntity<>(service.findAllStudentsBySchool(schoolId), HttpStatus.OK);
    }
}
