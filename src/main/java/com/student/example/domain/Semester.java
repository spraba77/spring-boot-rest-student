package com.student.example.domain;


import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "semester")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Semester{

    @Id
    @GeneratedValue()
    private long id;

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Column(nullable = false)
    private String semesterId;

    @Column(nullable = false)
    private String semesterName;



    public Semester() {
    }

    public Semester(String semesterId, String semesterName) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Semester {" +
                "id=" + id +
                ", semesterId='" + semesterId + '\'' +
                ", semesterName='" + semesterName +
                '}';
    }
}
