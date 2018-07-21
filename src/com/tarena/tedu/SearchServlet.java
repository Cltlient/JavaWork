package com.tarena.tedu;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.tarena.dao.StudentDao;
import com.tarena.util.DbUtil;
import com.tarena.util.ResponseUtil;

public class SearchServlet extends HttpServlet {
    
    DbUtil db = new DbUtil();
    StudentDao dao = new StudentDao();
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String stu_no = new String(req.getParameter("stu_no").getBytes("iso-8859-1"),"utf-8");
        
        Connection conn=null;
        
        try {
            
            conn=db.getConnection();
            
            int num = dao.destroyStudent(conn,stu_no);
            
            JSONObject result=new JSONObject();
            
            if(num>0){              
                result.put("success", "搜索成功");
            }else{
                result.put("errorMsg", "搜索失败");     
            }
            
            ResponseUtil.write(resp, result);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
    }
    
    }
    

