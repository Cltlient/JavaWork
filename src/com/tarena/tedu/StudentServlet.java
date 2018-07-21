package com.tarena.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tarena.dao.StudentDao;
import com.tarena.entity.PageBean;
import com.tarena.util.DbUtil;
import com.tarena.util.JSONUtil;
import com.tarena.util.ResponseUtil;

public class StudentServlet extends HttpServlet {
    
    DbUtil db = new DbUtil();
    StudentDao dao = new StudentDao();
    
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String currPage = req.getParameter("page");
        String rows = req.getParameter("rows");
        
        int Page = 0;
        
        if(currPage!=null){
           Page = Integer.parseInt(currPage);
       
        }
        
        PageBean pageBean = new PageBean(Page,Integer.parseInt(rows));
        
        Connection conn = null;
               
        try {
            conn = db.getConnection();
            JSONArray array = JSONUtil.rsToJson(dao.findALL(conn, pageBean));
            
            int total = dao.countStudent(conn);
            
            JSONObject result = new JSONObject();
            
            result.put("rows", array);
            
            result.put("total", total);
            
            ResponseUtil.write(resp, result);
            
        } catch (Exception e) {

            e.printStackTrace();
        }
        
    }
    
    
    
    
    
}
