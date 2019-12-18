package com.qis.h2_master_slaver.service;

import com.qis.h2_master_slaver.entity.Person;
import com.qis.h2_master_slaver.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @descn 人员service
 * @auther qis
 * @date 2019/12/18 13:02
 */
@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public int masterInsert(Person person) {
        return personMapper.insert(person);
    }

    public int masterUpdate(Person person) {
        return personMapper.update(person);
    }

    public int masterDelete(Person person) {
        return personMapper.delete(person);
    }

    public int masterTableCreate() {
        return personMapper.createTable();
    }

    public List<Person> masterSelectAll() {
        return personMapper.selectAll();
    }

    public int slaverTableCreate() {
        return personMapper.createTable();
    }

    public int slaverInsert(Person person) {
        return personMapper.insert(person);
    }

    public List<Person> slaverSelectAll() {
        return personMapper.selectAll();
    }
}
