package com.davault.fullstack.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = Arrays.asList(
            new Student(1L, "Joe Davault", "joe@smu.edu", Gender.MALE),
            new Student(2L, "Sarah Johnson", "sarah@smu.edu", Gender.FEMALE),
            new Student(3L, "Gregg Olson", "gregg@smu.edu", Gender.MALE)
        );
        return students;
    }
}