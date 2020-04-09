package com.vsii.schedulingtask.service.impl;

import com.vsii.schedulingtask.model.Student;
import com.vsii.schedulingtask.repository.StudentRepository;
import com.vsii.schedulingtask.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllByCreateTime(Date createTime) {
        studentRepository.deleteAllByCreateTime(createTime);
    }

}
