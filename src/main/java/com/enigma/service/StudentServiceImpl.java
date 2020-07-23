package com.enigma.service;

import com.enigma.Student;
import com.enigma.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Student student) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(student.getBirthDate(),now);

        Integer id = studentDao.countAll() + 1;
        student.setId(id);
        student.setAge(period.getYears());
        studentDao.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
    if(student.getId() == null )throw new RuntimeException("ID must be provided");
    else if (getStudentById(student.getId())==null) throw new RuntimeException("Student can not be found"+student.getId());

    studentDao.saveStudent(student);
        }

    @Override
    public List<Student> getAllStudent() {
        return new ArrayList<>(studentDao.getAllStudent().values());
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void deleteStudent(Student student) {
        if(student.getId() == null )throw new RuntimeException("ID must be provided");
        else if (getStudentById(student.getId())==null) throw new RuntimeException("Student can not be found"+student.getId());

        studentDao.deleteStudent(student);
    }

    @Override
    public Integer countAllStudent() {
        return studentDao.countAll();
    }
}
