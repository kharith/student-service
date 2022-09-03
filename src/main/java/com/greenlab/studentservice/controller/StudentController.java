package com.greenlab.studentservice.controller;

import com.greenlab.studentservice.model.Student;
import com.greenlab.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{student_id}")
    public Mono<Student> getStudentById(@PathVariable("student_id") String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/get")
    public Flux<Student> getStudents() {
        System.out.println("===========inside get==================");
        return studentService.getStudents();
    }

    @PutMapping("/{student_id}")
    public Mono<Student> updateStudent(@PathVariable("student_id") String id, @RequestBody Student student) {
        return studentService.updateStudent(student, id);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Mono<Student> createStudent() {
        System.out.println("==============="+new Date());
        Student student1=new Student();
        student1.setId("1");
        student1.setFirstName("nimal");
        student1.setLastName("perera");
        student1.setMiddleName("kumara");
        student1.setNic(12121212);
        student1.setCreatedDate(LocalDateTime.now());
        student1.setDeletedDate(LocalDateTime.now());
        student1.setLastModifiedDate(LocalDateTime.now());
        student1.setDob(LocalDateTime.now());
        return studentService.createStudent(student1);
    }

    @DeleteMapping("/{student_id}")
    public void deleteStudent(@PathVariable("student_id") String id) {
        studentService.deleteStudent(id);
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String testM() {
        System.out.println("===============test M==============");
        return "hello world";
    }

}
