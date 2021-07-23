package com.mm.securitydemo.controller;

import com.mm.securitydemo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "sagar"),
            new Student(2, "pavani"),
            new Student(3, "sanvi")

    );

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Integer id) {
        System.out.println(id);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        System.out.println(String.format("%s %s", id, student));
    }
}
