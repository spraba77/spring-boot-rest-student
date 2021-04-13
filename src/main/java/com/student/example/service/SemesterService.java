package com.student.example.service;

import com.student.example.dao.jpa.SemesterRepository;
import com.student.example.domain.Semester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SemesterService {

    private static final Logger log = LoggerFactory.getLogger(com.student.example.service.SemesterService.class);

    @Autowired
    private SemesterRepository semesterRepository;

    public SemesterService() {
    }

    public Semester createSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    public Semester getSemester(long id) {
        return semesterRepository.findOne(id);
    }

    public void updateSemester(Semester student) {
        semesterRepository.save(student);
    }

    public void deleteSemester(Long id) {
        semesterRepository.delete(id);
    }

    public Page<Semester> getAllSemesters(Integer page, Integer size) {
        Page pageOfHotels = semesterRepository.findAll(new PageRequest(page, size));
        if (size > 50) {
            //counterService.increment("Semester.SemesterService.getAll.largePayload");
        }
        return pageOfHotels;
    }
}

