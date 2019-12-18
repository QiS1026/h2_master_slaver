package com.qis.h2_master_slaver.mapper;

import com.qis.h2_master_slaver.entity.Person;

import java.util.List;

/**
 * @descn 人员mapper
 * @auther qis
 * @date 2019/12/18 13:12
 */
public interface PersonMapper {

    int insert(Person person);

    int update(Person person);

    List<Person> selectAll();

    int delete(Person person);

    int createTable();
}
