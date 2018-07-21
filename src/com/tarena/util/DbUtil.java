package com.tarena.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
        /*
         * JDBC --- 五部曲    ：1.加载驱动 
         * 2.连接数据库                    3.创建执行者执行SQL语句   
         * 4.处理结果                        5.关闭流
         * 
         * */
    String url  =  "jdbc:mysql://localhost:3306/test_web";
    String user =   "root";
    String password = "mysql";
    
    public Connection getConnection() throws Exception{
       Class.forName("com.mysql.jdbc.Driver");//加载驱动
       
       Connection connection = DriverManager.getConnection(url, user, password);
      
       return connection;     
    }
    

    public void closeCon(Connection con) throws SQLException{
        if(con!=null){
            con.close();
        }
    }

}


/*public static void main(String[] args) throws Exception {
    
    
    //匿名对象
    new DbUtil();
    //实例化对象
    DbUtil dbUtil = new DbUtil();
    
    
    //DbUtil db = new DbUtil();
    //Connection con = db.getConnection();
    
    System.out.println(new DbUtil().getConnection());
}*/
