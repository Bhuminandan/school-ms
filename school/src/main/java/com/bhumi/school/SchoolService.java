package com.bhumi.school;

import com.bhumi.school.client.StudentClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findAllSchoolsWithStudents(Integer studentId) {
        var school = repository.findById(studentId).orElse(
                School.builder()
                        .name("NOT FOUND")
                        .email("NOT FOUND")
                        .build()
        );

        var students = studentClient.findAllBySchoolId(studentId);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
