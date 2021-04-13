package com.student.example.dao.jpa;

import com.student.example.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository can be used to delegate CRUD operations against the data source
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Page findAll(Pageable pageable);
}
