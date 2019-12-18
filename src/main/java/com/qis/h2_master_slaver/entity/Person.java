package com.qis.h2_master_slaver.entity;

/**
 * @descn 人员表
 * @auther qis
 * @date 2019/12/18 12:15
 */
public class Person {

    private Integer id; // id，主键
    private String name; // 姓名

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
