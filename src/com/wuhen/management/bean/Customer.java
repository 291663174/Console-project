package com.wuhen.management.bean;

/**
 * @Author Wuhen
 * @Description Customer类为实体对象，用来封装客户信息
 * @Date 2020/8/31
 **/
public class Customer {
    /**
     * 客户姓名
     **/
    private String name;
    /**
     * 客户性别
     **/
    private char gender;
    /**
     * 客户年龄
     **/
    private int age;
    /**
     * 客户电话号码
     **/
    private String phonenumber;
    /**
     * 客户电子邮箱
     **/
    private String email;

    public Customer() {
    }

    public Customer(String name, char gender, int age, String phonenumber, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}