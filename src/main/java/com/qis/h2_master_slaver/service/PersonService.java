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

    /**
     * @descn 创建主库的表
     * @return int
     * @author qis
     * @date 2019/12/18 18:02
     */
    public int masterTableCreate() {
        return personMapper.createTable();
    }

    /**
     * @descn 创建从库的表
     * @return int
     * @author qis
     * @date 2019/12/18 18:02
     */
    public int slaverTableCreate() {
        return personMapper.createTable();
    }

    /**
     * @descn 主库中插入
     * @param person
     * @return int
     * @author qis
     * @date 2019/12/18 18:02
     */
    public int masterInsert(Person person) {
        return personMapper.insert(person);
    }

    /**
     * @descn 主库中更新
     * @param person
     * @return int
     * @author qis
     * @date 2019/12/18 18:02
     */
    public int masterUpdate(Person person) {
        return personMapper.update(person);
    }

    /**
     * @descn 主库中删除
     * @param person
     * @return int
     * @author qis
     * @date 2019/12/18 18:02
     */
    public int masterDelete(Person person) {
        return personMapper.delete(person);
    }

    /**
     * @descn 查询主库的全部数据
     * @return java.util.List<com.qis.h2_master_slaver.entity.Person>
     * @author qis
     * @date 2019/12/18 18:02
     */
    public List<Person> masterSelectAll() {
        return personMapper.selectAll();
    }

    /**
     * @descn 从库中插入
     * @param person
     * @return int
     * @author qis
     * @date 2019/12/18 18:02
     */
    public int slaverInsert(Person person) {
        return personMapper.insert(person);
    }

    /**
     * @descn 查询从库的全部数据
     * @return java.util.List<com.qis.h2_master_slaver.entity.Person>
     * @author qis
     * @date 2019/12/18 18:02
     */
    public List<Person> slaverSelectAll() {
        return personMapper.selectAll();
    }
}
