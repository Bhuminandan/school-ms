package com.bhumi.school;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {
    String name;
    String email;

    List<Student> students;
}
