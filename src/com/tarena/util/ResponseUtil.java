package com.tarena.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class ResponseUtil {
    
    public static void write(HttpServletResponse resp,JSONObject jsonObject) throws IOException{
        
        resp.setContentType("text/html;charset=utf-8");
 
        PrintWriter writer = resp.getWriter();
        
        writer.println(jsonObject.toString());
        
        writer.flush();
        
        writer.close();
        
    }
    
}
