package com.greenlab.studentservice.repository;

import com.greenlab.studentservice.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student,String> {
}
