package com.tarena.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tarena.entity.User;
import com.tarena.tedu.UserServlet;

/*
 * 完成数据库增删改查
 * 
 * */
public class UserDao {
    
    public User login(Connection con,User user) {
        String sql = "select * from user where userName=? and pwd=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            
                if(rs.next()){
                    return new User(rs.getInt(1),rs.getString(2),rs.getString(3));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }
}
