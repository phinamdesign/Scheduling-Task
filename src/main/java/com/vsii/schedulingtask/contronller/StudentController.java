package com.vsii.schedulingtask.contronller;

import com.vsii.schedulingtask.model.Student;
import com.vsii.schedulingtask.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> listStudent() throws ParseException {
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        Date date = new Date();
        student.setCreateTime(date);
        System.out.println("Date: " + date);
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @Scheduled(fixedRate = 600000)// 5 phút
    public void deleteStudent(){
        List<Student> students = (List<Student>) studentService.findAll();
        Date date = new Date();
        LOGGER.info("Tìm và xóa student quá thời gian lưu trữ");
        for (Student student: students){
            if (date.getTime()-student.getCreateTime().getTime()>1800000){
                studentService.delete(student.getId());
            }
        }
    }
}
