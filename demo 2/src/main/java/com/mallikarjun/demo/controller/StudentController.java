package com.mallikarjun.demo.controller;

import com.mallikarjun.demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(101, "Majun",90),
            new Student(121,"Mallu",99)
    ));

    @GetMapping("/student")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public Student student(@RequestBody Student student){
        students.add(student);
        return student;
    }

}
