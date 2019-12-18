package com.qis.h2_master_slaver.controller;

import com.qis.h2_master_slaver.entity.Person;
import com.qis.h2_master_slaver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @descn 人员controller
 * @auther qis
 * @date 2019/12/18 13:15
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "masterInsert")
    public int masterInsert(Integer id, String name) {
        return personService.masterInsert(new Person(id, name));
    }

    @RequestMapping(value = "masterUpdate")
    public int masterUpdate(Integer id, String name) {
        return personService.masterUpdate(new Person(id, name));
    }

    @RequestMapping(value = "masterDelete")
    public int masterDelete(Integer id) {
        return personService.masterDelete(new Person(id, null));
    }

    @RequestMapping(value = "masterTableCreate")
    public int masterTableCreate() {
        return personService.masterTableCreate();
    }

    @RequestMapping(value = "masterSelectAll")
    public List<Person> masterSelectAll() {
        return personService.masterSelectAll();
    }

    @RequestMapping(value = "slaverTableCreate")
    public int slaverTableCreate() {
        return personService.slaverTableCreate();
    }

    @RequestMapping(value = "slaverInsert")
    public int slaverInsert(Integer id, String name) {
        return personService.slaverInsert(new Person(id, name));
    }

    @RequestMapping(value = "slaverSelectAll")
    public List<Person> slaverSelectAll() {
        return personService.slaverSelectAll();
    }
}
