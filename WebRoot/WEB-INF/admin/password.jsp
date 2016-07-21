<%@ page language="java" import="java.util.*,com.qiye.service.*,com.qiye.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>软件学院视频站</title>
<link href="./css/web_main.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./include/flashWrite.js"></script>
<script language="javascript" src="./include/div.js"></script>
<script language="javascript" type="text/javascript" src="./js/flash.js"></script><strong></strong>
</head>
<% 
	Integer id= (Integer)request.getAttribute("id");
%>
<body>

<div  class="shell">
<form action="Admin_password?id=<%=id%>" method="post">
<table width="495" height="300" border="0" align="center">
    <tr>
      <td width="139" height="20"><div align="right" class="STYLE1"><s:text name="新密码" />:</div></td>
      <td width="190" height="20"><label>
        <input type="password" name="password"/>
      </label></td>
      <td width="144" height="20">&nbsp;</td>
    </tr>
   
    <tr>
      <td height="20"><div align="right" class="STYLE1"><s:text name="确认密码" />：</div></td>
      <td height="20"><label>
        <input type="password" name="repassword" onBlur="if(this.value!=this.form.password.value) alert('两次输入的密码不相同，请重新输入!');"/>
      </label></td>
      <td height="20">&nbsp;</td>
    </tr>
   <tr>
   	 <td height="20"   align="right" class="STYLE1"><label>
        <input type="submit" name="submit" value="修改" />
      </label></td>
   		
   </tr>
  </table>
  
</form>
</div>

</body>
</html>
