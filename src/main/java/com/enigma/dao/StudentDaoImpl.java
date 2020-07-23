package com.enigma.dao;

import com.enigma.Student;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {

    private  Map<Integer, Student> studentMap ;
    public StudentDaoImpl() {
    studentMap = new LinkedHashMap<>();
    }

    @Override
    public void saveStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public Map<Integer, Student> getAllStudent() {
        return studentMap;
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMap.get(id);
    }

    @Override
    public void deleteStudent(Student student) {
        studentMap.remove(student);
    }

    @Override
    public Integer countAll() {
        return studentMap.size();
    }
}
