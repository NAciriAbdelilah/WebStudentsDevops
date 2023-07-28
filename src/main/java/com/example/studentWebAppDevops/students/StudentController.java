package com.example.studentWebAppDevops.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {
    @Autowired
    StudentService service;

    //--------------------getAllStudents------------------------//
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return students;
    }
    //--------------------getStudentByI------------------------//
    @GetMapping("/students/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable("studentId") int id){
        Optional<Student> studentOptional = service.getStudent(id);
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student inixistant");
        }
    }

    //--------------------addStudent------------------------//
    @PostMapping("/students")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        Student newStudent = service.saveStudent(student);
        return ResponseEntity.ok("Student added");
    }

    //--------------------updateStudentByID------------------------//
    @PutMapping("/students/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable("studentId") int id, @RequestBody Student student){
        Optional<Student> studentOptional = service.getStudent(id);
        if (studentOptional.isPresent()){
            student.setId(id);
            service.saveStudent(student);
            return ResponseEntity.ok("Updated Student!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //--------------------deleteStudentByID------------------------//
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int id){
        Optional<Student> studentOptional = service.getStudent(id);
        if (studentOptional.isPresent()){
            Student deleteStudent = studentOptional.get();
            service.deleteStudent(deleteStudent);
            return ResponseEntity.ok("Deleted Student!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //--------------------deleteAllStudents------------------------//
    @DeleteMapping("/students/")
    public ResponseEntity<String> deleteAllStudents() {
        service.deleteAllStudents();
        return ResponseEntity.ok("All Students Deleted!");
    }

}
