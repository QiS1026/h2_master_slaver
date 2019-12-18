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

    /**
     * @descn 创建主库的表
     * @return int
     * @author qis
     * @date 2019/12/18 17:58
     */
    @RequestMapping(value = "masterTableCreate")
    public int masterTableCreate() {
        return personService.masterTableCreate();
    }

    /**
     * @descn 创建从库的表
     * @return int
     * @author qis
     * @date 2019/12/18 17:58
     */
    @RequestMapping(value = "slaverTableCreate")
    public int slaverTableCreate() {
        return personService.slaverTableCreate();
    }

    /**
     * @descn 主库中插入
     * @param id
     * @param name
     * @return int
     * @author qis
     * @date 2019/12/18 17:58
     */
    @RequestMapping(value = "masterInsert")
    public int masterInsert(Integer id, String name) {
        return personService.masterInsert(new Person(id, name));
    }

    /**
     * @descn 主库中更新
     * @param id
     * @param name
     * @return int
     * @author qis
     * @date 2019/12/18 17:58
     */
    @RequestMapping(value = "masterUpdate")
    public int masterUpdate(Integer id, String name) {
        return personService.masterUpdate(new Person(id, name));
    }

    /**
     * @descn 主库中删除
     * @param id
     * @return int
     * @author qis
     * @date 2019/12/18 17:58
     */
    @RequestMapping(value = "masterDelete")
    public int masterDelete(Integer id) {
        return personService.masterDelete(new Person(id, null));
    }

    /**
     * @descn 查询主库的全部数据
     * @return java.util.List<com.qis.h2_master_slaver.entity.Person>
     * @author qis
     * @date 2019/12/18 17:58
     */
    @RequestMapping(value = "masterSelectAll")
    public List<Person> masterSelectAll() {
        return personService.masterSelectAll();
    }

    /**
     * @descn 从库中插入
     * @param id
     * @param name
     * @return int
     * @author qis
     * @date 2019/12/18 17:58
     */
    @RequestMapping(value = "slaverInsert")
    public int slaverInsert(Integer id, String name) {
        return personService.slaverInsert(new Person(id, name));
    }

    /**
     * @descn 查询从库的全部数据
     * @return java.util.List<com.qis.h2_master_slaver.entity.Person>
     * @author qis
     * @date 2019/12/18 17:58
     */
    @RequestMapping(value = "slaverSelectAll")
    public List<Person> slaverSelectAll() {
        return personService.slaverSelectAll();
    }
}
