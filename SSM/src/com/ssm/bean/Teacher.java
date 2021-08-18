package com.ssm.bean;

import java.util.Date;

/**
 * @author Abraham
 * @create 23:54/周三/28/07/2021
 */
public class Teacher {
    private Integer id;
    private String name;
    private String address;
    private Date birth;
    private String course;

    public Teacher(Integer id, String name, String address, Date birth, String course) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birth = birth;
        this.course = course;
    }

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                ", course='" + course + '\'' +
                '}';
    }
}
