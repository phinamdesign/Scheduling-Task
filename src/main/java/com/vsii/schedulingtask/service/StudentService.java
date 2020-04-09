package com.vsii.schedulingtask.service;

import com.vsii.schedulingtask.model.Student;

import java.util.Date;
import java.util.Optional;

public interface StudentService {
    Optional<Student> findById(Long id);
    Iterable<Student> findAll();
    Student save(Student student);
    void delete(Long id);
    void deleteAllByCreateTime(Date createTime);
}
