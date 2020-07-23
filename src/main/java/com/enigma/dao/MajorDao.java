package com.enigma.dao;

import com.enigma.Major;
import com.enigma.Student;

import java.util.Map;

public interface MajorDao {
    public void saveMajor(Major major);
    public Major getMajorByID(Integer id);
    public Integer countAllMajor();
    public Map<Integer, Major> getAllMajor();

}
