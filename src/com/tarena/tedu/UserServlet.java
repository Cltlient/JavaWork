package com.tarena.tedu;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.dao.UserDao;
import com.tarena.entity.User;
import com.tarena.util.DbUtil;
import com.tarena.util.StringUtil;

public class UserServlet extends HttpServlet{
    UserDao dao = new UserDao();
    DbUtil db = new DbUtil();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
           
           //req.setCharacterEncoding("utf-8");       
           // String name = req.getParameter("Username");
           String name = new String(req.getParameter("userName").getBytes("iso-8859-1"),"utf-8"); 
           
           String pwd  = req.getParameter("pwd");

           if(StringUtil.isEmpty(name) || StringUtil.isEmpty(pwd)){
               req.setAttribute("error", "用户名或者密码不能为空");
               
               req.getRequestDispatcher("index.jsp").forward(req, resp);
               
           }
           
           User user  = new User(name, pwd);
           
           Connection con = null;
           try{
               con = db.getConnection();
           }catch(Exception e){
               e.printStackTrace();
           }
           
           User loginUser = dao.login(con, user);
           
           if(loginUser == null){
               req.setAttribute("error", "用户名或者密码错误");               
               req.getRequestDispatcher("index.jsp").forward(req, resp);
                   
           }else{
               
               resp.sendRedirect("main.jsp");
           }
           
           
           
    }


}
