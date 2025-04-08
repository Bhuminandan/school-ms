package com.bhumi.school;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    String firstName;
    String lastName;
    String email;
}
