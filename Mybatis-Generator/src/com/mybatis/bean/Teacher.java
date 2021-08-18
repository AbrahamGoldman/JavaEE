package com.mybatis.bean;

import java.util.Date;

public class Teacher {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.id
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.name
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.adress
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    private String adress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.birth_date
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    private Date birthDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_teacher.class_name
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    private String className;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.id
     *
     * @return the value of t_teacher.id
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.id
     *
     * @param id the value for t_teacher.id
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.name
     *
     * @return the value of t_teacher.name
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.name
     *
     * @param name the value for t_teacher.name
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.adress
     *
     * @return the value of t_teacher.adress
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public String getAdress() {
        return adress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.adress
     *
     * @param adress the value for t_teacher.adress
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.birth_date
     *
     * @return the value of t_teacher.birth_date
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.birth_date
     *
     * @param birthDate the value for t_teacher.birth_date
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_teacher.class_name
     *
     * @return the value of t_teacher.class_name
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", birthDate=" + birthDate +
                ", className='" + className + '\'' +
                '}';
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_teacher.class_name
     *
     * @param className the value for t_teacher.class_name
     *
     * @mbg.generated Fri Jul 30 21:34:44 GMT+08:00 2021
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}