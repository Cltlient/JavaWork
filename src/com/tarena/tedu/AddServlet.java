package com.tarena.tedu;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.tarena.dao.StudentDao;
import com.tarena.entity.Student;
import com.tarena.util.DbUtil;
import com.tarena.util.ResponseUtil;

public class AddServlet extends HttpServlet {

    DbUtil db = new DbUtil();
    StudentDao dao = new StudentDao();
    
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //req.getRequestDispatcher("utf-8");
        
        String stu_no =new String(req.getParameter("stu_no").getBytes("iso-8859-1"),"utf-8");

        String stu_name = new String(req.getParameter("stu_name").getBytes("iso-8859-1"),"utf-8");
        
        String stu_grade =  new String(req.getParameter("stu_grade").getBytes("iso-8859-1"),"utf-8");
        
        String stu_sex =  new String(req.getParameter("stu_sex").getBytes("iso-8859-1"),"utf-8");
        
        Student student = new Student(Integer.parseInt(stu_no),stu_name,stu_grade,stu_sex);
        
        Connection conn = null;
        

        try {
            conn = db.getConnection();
            
            int num = dao.addStudent(conn, student);
            
            JSONObject result = new JSONObject();

            if(num>0){
                result.put("success", "添加成功");
            }else{
                result.put("errorMsg", "添加失败");
            }
            
            ResponseUtil.write(resp, result);
            
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    
}
