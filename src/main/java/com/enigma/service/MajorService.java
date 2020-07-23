package com.enigma.service;

import com.enigma.Major;

import java.util.List;
import java.util.Map;

public interface MajorService {
    public void saveMajor(Major major);
    public Major getMajorByID(Integer id);
    public Integer countAll();
    public List <Major> getAllMajor();

}
