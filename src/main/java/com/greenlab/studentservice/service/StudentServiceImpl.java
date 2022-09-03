package com.greenlab.studentservice.service;

import com.greenlab.studentservice.model.Student;
import com.greenlab.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Mono<Student> createStudent(Student student) {
        System.out.println("--------- i c s-------------");
        return studentRepository.save(student);
    }

    @Override
    public Mono<Student> updateStudent(Student student, String id) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public Flux<Student> getStudents() {
        System.out.println("===============2222");
        return studentRepository.findAll();
    }

    @Override
    public Mono<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudent(String id) {
        Mono<Student> studentMono = studentRepository.findById(id);
        studentMono.doOnNext(student -> {
            student.setDeletedDate(LocalDateTime.now());
            studentRepository.save(student);
        });
    }
}
