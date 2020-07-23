package com.enigma.service;

import com.enigma.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student student);

    public void updateStudent(Student student);

    public List<Student> getAllStudent();

    public Student getStudentById(Integer id);

    public void deleteStudent(Student student);

    public Integer countAllStudent();
}
