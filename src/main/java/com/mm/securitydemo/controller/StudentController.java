package com.mm.securitydemo.controller;

import com.mm.securitydemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "sagar"),
            new Student(2, "pavani"),
            new Student(3, "sanvi")

    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") int id) {
        return STUDENTS.stream()
                .filter(student -> id == student.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("student " + id + "not found"));
    }
}
