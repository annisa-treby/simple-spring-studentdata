package com.enigma.service;

import com.enigma.Major;
import com.enigma.dao.MajorDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MajorServiceImpl implements MajorService{

    @Autowired
    MajorDao majorDao;

    public MajorServiceImpl(MajorDao majorDao) {
        this.majorDao = majorDao;
    }

    @Override
    public void saveMajor(Major major) {
        Integer id = majorDao.countAllMajor() +1;
        major.setId(id);

        majorDao.saveMajor(major);
    }

    @Override
    public Major getMajorByID(Integer id) {
        return majorDao.getMajorByID(id);
    }

    @Override
    public Integer countAll() {
        return majorDao.countAllMajor();
    }

    @Override
    public List<Major> getAllMajor() {
        return new ArrayList<>(majorDao.getAllMajor().values());
    }
}
