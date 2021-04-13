package com.student.example.domain;


import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "student")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student{

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private int studentId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column()
    private String className;

    @Column()
    String nationality;



    public Student() {
    }

    public Student(int studentId, String firstName, String lastName, String className, String nationality) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.nationality = nationality;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClassName() {
        return className;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Student {" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", className='" + className + '\'' +
                ", nationality=" + nationality +
                '}';
    }
}
