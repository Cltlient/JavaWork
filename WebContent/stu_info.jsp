<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
    <script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
    
         var url;
    
         function addStudent(){
        	$("#dlg").dialog("open").dialog("setTitle","添加信息");
        	$("#fm").form("clear");
        	url="addStudent";
         }
         
         function saveStudent(){
             $('#fm').form('submit',{
                 url: url,
                 onSubmit: function(){
                     return $(this).form('validate');
                 },
                 success: function(result){
                     var result = eval('('+result+')');
                     if (result.errorMsg){
                         $.messager.show({
                             title: 'Error',
                             msg: result.errorMsg
                         });
                     } else {
                         $('#dlg').dialog('close');        
                         $('#dg').datagrid('reload');    
                     }
                 }
             });
         }
         
         function destroyStudent(){
        	
             var rows = $('#dg').datagrid('getSelected');
             if (rows){
                 $.messager.confirm('删除信息','确认删除本条信息?',function(r){
                     if (rows){
                         $.post('destroyStudent',{stu_no:rows.stu_no},function(result){
                             if (result.success){
                                 $('#dg').datagrid('reload');    // reload the user data
                             } else {
                                 $.messager.show({    // show error message
                                     title: 'Error',
                                     msg: result.errorMsg
                                 });
                             }
                         },'json');l
                     }
                 });
             }
         }
   
    
         function editStudent(){
        	
             var row = $('#dg').datagrid('getSelected');
             if (row){
                 $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改信息');
                 $('#fm').form('load',row);
                 url = 'editStudent?stu_id='+row.stu_id;
             }
         }
         
         function searchStudent(){
        	 
             $.post('editStudent',{stu_no:stu_no}

        	 
         }


    </script>
    
</head>
<body>
    <table class="easyui-datagrid" fitColumns="true" title="学生信息管理"
        pagination="true"  rownumbers="true" id="dg"  url="stu_info"   toolbar="#tb"
    >
        <thead>
            <tr>
                <th field="cb" checkbox="true"></th>
                <th field="stu_id" width=50 align="center">编号</th>
                <th field="stu_no" width=100 align="center">学生学号</th>
                <th field="stu_name" width=100 align="center">学生姓名</th>
                <th field="stu_grade" width=100 align="center">学生班级</th>
                <th field="stu_sex" width=50 align="center">性别</th>
            </tr>
        </thead>    
    </table>
    
    <div id="tb">
        <a href="javascript:addStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
        <a href="javascript:destroyStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
        <a href="javascript:editStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" >修改</a>
        <div style="float: right">学生学号：<input type="text" name="stu_no" >
            <a href="javascript:searchStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
        </div>   

    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:10px">
                <input name="stu_no" id="stu_no" class="easyui-textbox" required="true" label="stu_no:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="stu_name" class="easyui-textbox" required="true" label="stu_name:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="stu_grade" class="easyui-textbox" required="true" label="stu_grade:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="stu_sex" class="easyui-textbox" required="true"  label="stu_sex:" style="width:100%">
            </div>
        </form>
    </div>
    
    <div id="dlg-buttons">
        <a href="javascript:saveStudent()" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    
</body>
</html>