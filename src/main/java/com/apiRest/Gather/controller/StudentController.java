package com.apiRest.Gather.controller;

import com.apiRest.Gather.exception.RessourceNotFoundException;
import com.apiRest.Gather.model.Student;
import com.apiRest.Gather.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @CrossOrigin
    @PostMapping("/student")
    public Student createStudent(@Validated @RequestBody Student student){
        Student student1 = studentRepository.save(student);
        return student1;
    }
    @CrossOrigin
    @GetMapping("/student")
    public Page<Student> listStudents(Pageable pageable){
        return studentRepository.findAll(pageable);
    }
    @CrossOrigin
    @GetMapping("/student/{id}")
    public Student getById(@PathVariable Long id){
        Student student = studentRepository.getOne(id);
        return student;
    }
    @CrossOrigin
    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new RessourceNotFoundException("Student not found with id " + id));
    }
}
