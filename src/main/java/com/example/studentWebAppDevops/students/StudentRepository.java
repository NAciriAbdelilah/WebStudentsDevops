package com.example.studentWebAppDevops.students;

import org.springframework.data.repository.CrudRepository;
public interface StudentRepository  extends CrudRepository <Student,Integer> {
}
