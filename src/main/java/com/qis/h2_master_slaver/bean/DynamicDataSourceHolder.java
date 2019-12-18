package com.qis.h2_master_slaver.bean;

import com.qis.h2_master_slaver.enums.DBType;

/**
 * @descn 使用ThreadLocal技术来记录当前线程中的数据源的type
 * @auther qis
 * @date 2019/12/18 11:43
 */
public class DynamicDataSourceHolder {

    // 使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<DBType> holder = new ThreadLocal<DBType>();

    /**
     * @descn 设置当前线程的数据源类型
     * @param dbType 数据源类型
     * @return void
     * @author qis
     * @date 2019/12/18 12:09
     */
    public static void putDataSourceKey(DBType dbType) {
        holder.set(dbType);
    }

    /**
     * @descn 获取当前线程的数据源类型
     * @return com.qis.h2_master_slaver.database.DBType
     * @author qis
     * @date 2019/12/18 12:09
     */
    public static DBType getDataSourceKey() {
        return holder.get();
    }

    /**
     * @descn 标记当前线程使用主数据源
     * @return void
     * @author qis
     * @date 2019/12/18 12:09
     */
    public static void markMaster() {
        putDataSourceKey(DBType.master);
        System.out.println("切换到master数据源");
    }

    /**
     * @descn 标记当前线程使用从数据源
     * @return void
     * @author qis
     * @date 2019/12/18 12:09
     */
    public static void markSlave() {
        putDataSourceKey(DBType.slaver);
        System.out.println("切换到slaver数据源");
    }
}
