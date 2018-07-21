<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
    <script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    
    <style type="text/css">
        a{
            text-decoration: none;
            margin-left: 15px;
        }

    </style>
   
    <script type="text/javascript">
    $(function(){
        //界面显示完后在运行这个
        var treedata=[{
            text:"目录一",
            children:[{
                text:"学员信息管理",
                attributes:{
                    url:"stu_info.jsp"
                }
            },{
                text:"老师信息管理",
                attributes:{
                    url:"t_info.jsp"
                }
            }]
        
        }];
        /* 实例化树菜单 */
        $("#tree").tree({
            data:treedata,
            lines:true,
            onClick:function(nodes){
                if(nodes.attributes){
                    openTab(nodes.text,nodes.attributes.url);
                }
            }
        })
        
        function openTab(text,url){
            var content1="<iframe src="+url+" style='width:89%;height:74%'></iframe>";
        
            if($("#tabs").tabs('exists',text)){
            	
            	$("tabs").tabs('select',text)
            }else{
            	
                
              $("#tabs").tabs('add',{
                title:text,
                closable:true,
                content:content1
                
            })
            
         }
        }
        
    })
    
    </script>
</head>
<body class="easyui-layout">

        <div region="north" style="height:50px;line-height: 45px;text-align: center;background-color: pink">
              <font size="6px" color="red">未满18岁禁止入内!!</font>
         </div>
        
        <div region="south" style="height:100px;line-height: 45px;text-align: center;font-size:18px">
            <a href="http://www.cqupt.edu.cn">CQUPT</a>
            <a href="http://www.jeasyui.com/">Easyui</a>
            <a href="https://www.oracle.com">Oracle</a>
            <a href="http://www.bootcss.com">Bootcss</a>            
            <a href="http://www.4399.com">4399</a>            
            <a href="http://www.tmooc.cn">达内</a>
            <div><font size="2px">Copyright@Client</font></div>
        </div>
        
        <div region="west"  style="width:150px" title="导航菜单">
            <ul id="tree"><!-- 无序列表 -->
                
            </ul>
        </div>
        
        <div region="center" class="easyui-tabs" id="tabs" border="false" fit="true" >
            <div title="首页" style="background-image: url('image/3.jpg');text-align: center;">
                   <font size="9px" color="pink">欢迎进入</font>>          
            </div>        
        </div>
</body>
</html>