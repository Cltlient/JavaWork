package com.tarena.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {

    public static JSONArray rsToJson(ResultSet rs) throws Exception{
        
        JSONArray array=new JSONArray();
        
        while(rs.next()){
            
            ResultSetMetaData metaData = rs.getMetaData();
            
            int count=metaData.getColumnCount();
            
            JSONObject jo=new JSONObject();
                
            for(int i=1;i<=count;i++){
                
                Object object = rs.getObject(i);
                
                jo.put(metaData.getColumnName(i),object);
                
            }
            
            array.add(jo);
        }
        return array;
        
    }
}
