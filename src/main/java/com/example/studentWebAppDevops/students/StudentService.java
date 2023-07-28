package com.example.studentWebAppDevops.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository repositoryStudent;
    public List<Student> getAllStudents() {
        List<Student> students = (List<Student>) repositoryStudent.findAll();
        return students;
    }
    public Optional<Student> getStudent(int id) {
        Optional<Student> studentOptional=repositoryStudent.findById(id);
        return studentOptional;
    }
    public Student saveStudent(Student student) {
        return repositoryStudent.save(student);
    }
    public void deleteStudent(Student student) {
        repositoryStudent.delete(student);
    }

    public void deleteAllStudents() {
        repositoryStudent.deleteAll();
    }

}