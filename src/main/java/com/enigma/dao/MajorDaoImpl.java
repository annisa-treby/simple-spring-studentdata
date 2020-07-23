package com.enigma.dao;

import com.enigma.Major;

import java.util.LinkedHashMap;
import java.util.Map;

public class MajorDaoImpl implements MajorDao{

    private Map<Integer, Major> majorMap = new LinkedHashMap<>();


    @Override
    public void saveMajor(Major major) {
    majorMap.put(major.getId(),major);
    }

    @Override
    public Major getMajorByID(Integer id) {
        return majorMap.get(id);
    }

    @Override
    public Integer countAllMajor() {
        return majorMap.size();
    }

    @Override
    public Map<Integer, Major> getAllMajor() {
        return majorMap;
    }
}
