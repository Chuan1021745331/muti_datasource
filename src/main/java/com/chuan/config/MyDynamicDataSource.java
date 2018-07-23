package com.chuan.config;

import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @类名:
 * @包名: com.chuan.config
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/7/20 14:36
 */
public class MyDynamicDataSource extends AbstractRoutingDataSource {

    private static ThreadLocal<String> dataSourceName=new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("成功修改数据源 determineCurrentLookupKey");
        String s = dataSourceName.get();
        return this.getDataSource();
    }

    public static void setDataSource(String name){
        dataSourceName.set(name);
        System.out.println("成功修改数据源");
    }

    public static String getDataSource(){
        return dataSourceName.get();
    }

}
