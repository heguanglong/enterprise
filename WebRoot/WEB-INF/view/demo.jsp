<%@ page language="java" import="java.util.*,com.qiye.service.*,com.qiye.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>软件学院视频站</title>
<link href="/css/web_main.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="/include/flashWrite.js"></script>
<script language="javascript" src="/include/div.js"></script>
<script language="javascript" type="text/javascript" src="./js/flash.js"></script><strong></strong>
</head>

<body>
<!--start master_head-->
<div id="master_head">
	<div class="head_logo">

	</div>
	<div class="head_advertising"></div>
	<div class="head_txt">中文 <br />English</div>
    <div class="no_float"></div>
</div>
<!--end master_head-->

<!--start master_menu-->
<jsp:include page="/menu.jsp"></jsp:include>

<!--end master_menu-->

<!--start master_body-->
<div id="master_body">
	<div id="body_left">
	  	 
		 <!--start tutorial-->
		 <div class="left_content_title"><img src="images/arrow_01.gif" class="title_img" />公司简介</div>
		 <div class="left_content_top"></div>
	  <div class="left_content_main">
	  	左边
	    
	    </div>
		<div class="left_content_bottom"></div>
 
		 <!--end down_template-->
         <!--start down_flash-->
         <div class="left_content_main"></div>
		 <!--end down_flash-->
    </div>
	
	
	
	<div id="body_right">
	 
	  <!--start advertising--><!--end advertising-->
      <!--start class-->
		<div align="center">
	 中间
	  </div>
	  <!--end class-->
	  <!--start template-->
	   <div class="right_content_top"></div>
	   <div class="right_content_main">
		 <div class="right_content_title"><img src="images/arrow_01.gif" class="title_img" />新闻中心　　　　　<font color="#FFFF00">共2010个</font>	   </div>
		 <div class="right_content_more">更多...	   </div>
		 <div class="right_content">
		  
		下面
		 </div>
	   </div>
	  <div class="right_content_bottom"><img src="images/right_content_bottom.gif"></div>
	  <!--end template-->
	 
	 
	  
	  

	</div>
	<div class="no_float"></div>
</div>
<!--end master_body-->


</body>
</html>
