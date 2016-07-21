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
	User user = (User)request.getAttribute("user");
%>
<body>

<div  class="shell">
<form action="Admin_updateuser?id=<%=user.getId()%>" method="post" >
<table width="495" height="300" border="0" align="center">
    <tr>
      <td width="139" height="20"><div align="right" class="STYLE1"><s:text name="姓名" />:</div></td>
      <td width="190" height="20"><label>
        <input type="text" name="name" value="<%=user.getName() %>"/>
      </label></td>
      <td width="144" height="20">&nbsp;</td>
    </tr>
   
    <tr>
      <td height="20"><div align="right" class="STYLE1"><s:text name="邮箱" />：</div></td>
      <td height="20"><label>
        <input type="text" name="email" value="<%=user.getEmail() %>" />
      </label></td>
      <td height="20">&nbsp;</td>
    </tr>
    <tr>
      <td height="20"><div align="right" class="STYLE1"><s:text name="性别" />：</div></td>
      <td height="20"><label>
        <input type="text" name="sex" value="<%=user.getSex() %>" />
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
