package com.apiRest.Gather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiRest.Gather.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
