package com.qis.h2_master_slaver.aop;

import com.qis.h2_master_slaver.bean.DynamicDataSourceHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @descn 定义数据源的AOP切面，该类控制了使用Master还是Slave。
 * 如果事务管理中配置了事务策略，则采用配置的事务策略中的标记了ReadOnly的方法是用Slave，其它使用Master。
 * 如果没有配置事务管理的策略，则采用方法名匹配的原则，以query、find、get开头方法用Slave，其它用Master。
 * @auther qis
 * @date 2019/12/18 11:56
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("execution(* com.qis.h2_master_slaver.service..*.slaver*(..))")
    public void slaverPointCut() {
    }

    @Pointcut("execution(* com.qis.h2_master_slaver.service..*.master*(..))")
    public void masterPointCut() {
    }

    /**
     * @descn h2_master_slaver.service中的以 slaver 开头的方法使用从数据源
     * @return void
     * @author qis
     * @date 2019/12/18 12:13
     */
    @Before("slaverPointCut()")
    public void slaver() {
        DynamicDataSourceHolder.markSlave();
    }

    /**
     * @descn h2_master_slaver.service中的以 master 开头的方法使用主数据源
     * @return void
     * @author qis
     * @date 2019/12/18 12:13
     */
    @Before("masterPointCut()")
    public void master() {
        DynamicDataSourceHolder.markMaster();
    }
}
