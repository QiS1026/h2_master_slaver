package com.qis.h2_master_slaver.config;

import com.qis.h2_master_slaver.bean.DynamicDataSource;
import com.qis.h2_master_slaver.enums.DBType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @descn 数据源配置
 * @auther qis
 * @date 2019/12/18 10:40
 */
@Configuration
public class DataSourceConfig {

    /**
     * @descn 创建主数据库的数据源
     * @return javax.sql.DataSource
     * @author qis
     * @date 2019/12/18 10:50
     */
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @descn 创建从数据库的数据源
     * @return javax.sql.DataSource
     * @author qis
     * @date 2019/12/18 10:51
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slaver")
    public DataSource slaverDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @descn 动态数据源
     * @param masterDataSource 主数据库数据源
     * @param slaverDataSource 从数据数据源
     * @return javax.sql.DataSource
     * @author qis
     * @date 2019/12/18 12:07
     */
    @Bean
    public DataSource dynamicDataSource(@Qualifier("masterDataSource") DataSource masterDataSource, @Qualifier("slaverDataSource") DataSource slaverDataSource) {
        Map<Object, Object> map = new HashMap<>();
        map.put(DBType.master, masterDataSource);
        map.put(DBType.slaver, slaverDataSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        dynamicDataSource.setTargetDataSources(map);
        return dynamicDataSource;
    }
}
