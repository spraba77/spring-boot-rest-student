package com.student.example.service;

import com.student.example.dao.jpa.StudentRepository;
import com.student.example.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final Logger log = LoggerFactory.getLogger(com.student.example.service.StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public StudentService() {
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(long id) {
        return studentRepository.findOne(id);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    public Page<Student> getAllStudents(Integer page, Integer size) {
        Page pageOfHotels = studentRepository.findAll(new PageRequest(page, size));
        if (size > 50) {
            //counterService.increment("Student.StudentService.getAll.largePayload");
        }
        return pageOfHotels;
    }
}

