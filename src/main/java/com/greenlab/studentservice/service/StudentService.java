package com.greenlab.studentservice.service;

import com.greenlab.studentservice.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface StudentService {
    public Mono<Student> createStudent(Student student);

    public Mono<Student> updateStudent(Student student, String id);

    public Flux<Student> getStudents();

    public Mono<Student> getStudentById(String id);

    public void deleteStudent(String id);
}
