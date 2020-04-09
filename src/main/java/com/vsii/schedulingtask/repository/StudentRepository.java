package com.vsii.schedulingtask.repository;

import com.vsii.schedulingtask.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteAllByCreateTime(Date createTime);
}
