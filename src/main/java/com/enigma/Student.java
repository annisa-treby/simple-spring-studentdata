package com.enigma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private Integer id;
private String name;
private String address;
private String phoneNumber;
private LocalDate birthDate;
private Integer age;
private Major major;

    public Student() {
    }

    @Override
    public String toString() {
        return "id\t\t:" + id +
                "\nname\t:'" + name + '\'' +
                "\naddress\t:'" + address + '\'' +
                "\nphoneNumber\t:'" + phoneNumber + '\'' +
                "\nbirthDate\t:" + birthDate +
                "\nage\t:" + age +
                "\nmajor\t:" +major;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}


