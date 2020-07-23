package com.enigma.dao;

import com.enigma.Student;

import java.util.Map;

public interface StudentDao {
    public void saveStudent(Student student);

    public Map<Integer, Student> getAllStudent();

    public Student getStudentById(Integer id);

    public void deleteStudent(Student student);

    public Integer countAll();
}
