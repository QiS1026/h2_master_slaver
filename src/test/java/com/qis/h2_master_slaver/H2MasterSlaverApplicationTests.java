package com.qis.h2_master_slaver;

import com.qis.h2_master_slaver.controller.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class H2MasterSlaverApplicationTests {

    @Autowired
    private PersonController personController;

    @Test
    void contextLoads() {
        personController.masterTableCreate();
        personController.masterInsert(1, "张三");
        System.out.println(personController.masterSelectAll());

        personController.slaverTableCreate();
        personController.slaverInsert(1, "李四");
        System.out.println(personController.slaverSelectAll());
    }

}
