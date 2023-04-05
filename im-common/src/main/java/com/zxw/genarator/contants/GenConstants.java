package com.zxw.genarator.contants;


public class GenConstants {

    /**
     * 数据库驱动
     */
    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 主库数据源
     */
    public static final String DATA_SOURCE_BASE_URL = "jdbc:mysql://127.0.0.1:3306/cloud_order?serverTimezone=CTT&autoReconnect=true&autoReconnectForPools=true&useUnicode=true&characterEncoding=UTF8&useSSL=false&statementInterceptors=brave.mysql.TracingStatementInterceptor";


    /**
     * 数据库用户名
     */
    public static final String USER_NAME = "root";

    /**
     * 数据库密码
     */
    public static final String PASSWORD = "123456";
}
