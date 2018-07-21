<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
    <script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <style>
            #ipt1{
                width:250px;
                height: 30px;
                text-align: center;    
            }     
           #ipt2{
                width:250px;
                height: 30px;
                text-align: center;
                
            }     
           #ipt3{
                width:250px;
                height: 30px;
                text-align: center;
                
            }    
             
    </style>
</head>
<body style="background-image:url('image/2.jpg')">

    <div style="width:400px;height:300px;margin: 200px auto">

    <div id="p" class="easyui-panel" title="欢迎登陆" style="width:400px;height:350px;padding:10px;opacity:0.5;background-color:#aabcca;">
        <form action="user" method="post">  <!-- 表单提交:Username,Password,提交方式：post ,get-->
        <div style="width: 250px;height: 30px;margin: 20px auto">
         <input type="text" name="userName" id="ipt1" placeholder="请输入用户名。"> 
         </div>

        <div style="width: 250px;height: 30px;margin: 20px auto">
          <input type="password" name="pwd" id="ipt2" placeholder="请输入密码。"> 
        </div>
        
        <div style="width: 250px;margin: 0px auto;text-align:center">
           <font color="red" size="4px">${error}</font>
        </div>
        
         <div style="width: 250px;height: 30px;margin: 60px auto">
          <input type="submit" value="登陆" id="ipt3"> 
         </div>
      
        </form>
    </div>

    </div>
</body>
</html>