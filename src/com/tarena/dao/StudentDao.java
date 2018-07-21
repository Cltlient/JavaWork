package com.tarena.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tarena.entity.PageBean;
import com.tarena.entity.Student;

public class StudentDao {
	//查询所有数据
	public ResultSet findALL(Connection conn,PageBean pageBean){
		
		StringBuffer sb = new StringBuffer("select * from student");
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		
		try {
			PreparedStatement ps = conn.prepareStatement(sb.toString());
			return ps.executeQuery();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//查询所有条数
	
	public int countStudent(Connection conn){
		StringBuffer sb = new StringBuffer("select count(*) as total from student");
		try {
			PreparedStatement ps = conn.prepareStatement(sb.toString());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt("total");
				
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return 0;
	}
	
	//添加用户
	public int addStudent(Connection conn,Student student) throws SQLException{
        
	        StringBuffer sb = new StringBuffer("insert into student values(null,?,?,?,?) ");

	        PreparedStatement ps = conn.prepareStatement(sb.toString());
	        
	        ps.setInt(1, student.getStu_no());  
	        
	        ps.setString(2, student.getStu_name());   
	        
	        ps.setString(3, student.getStu_grade());  
	        
	        ps.setString(4, student.getStu_sex());   
	        
	        return ps.executeUpdate();
	    
	    
	}
	
	//删除用户
	   public int destroyStudent(Connection conn,String stu_no) throws SQLException{
	        
           StringBuffer sb = new StringBuffer("delete from student where stu_no=?");

           PreparedStatement ps = conn.prepareStatement(sb.toString());
           
           ps.setString(1,stu_no );  
   
           
           return ps.executeUpdate();
       
       
   }
	  //编辑用户
	    public int editStudent(Connection conn,Student student) throws SQLException{
	        
	            StringBuffer sb = new StringBuffer("update student set stu_no=?,stu_name=?,stu_grade=?,stu_sex=? where stu_id=? ");

	            PreparedStatement ps = conn.prepareStatement(sb.toString());
	            
	            ps.setInt(1, student.getStu_no());  
	            
	            ps.setString(2, student.getStu_name());   
	            
	            ps.setString(3, student.getStu_grade());  
	            
	            ps.setString(4, student.getStu_sex());   
	            
	            ps.setInt(5, student.getStu_id());
	            
	            return ps.executeUpdate();
	        
	        
	    }
	   //查询用户
	    public int searchStudent(Connection conn,Student student) throws SQLException{
            
            StringBuffer sb = new StringBuffer("select * from student where stu_no=");

            PreparedStatement ps = conn.prepareStatement(sb.toString());
            
            ps.setInt(1, student.getStu_no());  
            
            return ps.executeUpdate();
        
        
    }
}