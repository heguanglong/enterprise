<%@ page language="java" import="java.util.*,com.qiye.service.*,com.qiye.entity.*,com.qiye.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>企业门户网站</title>
<link href="<%=basePath %>css360/style.css" rel="stylesheet" type="text/css"/>
<style>
.joblist dl {border-bottom:1px dashed #ddd; padding:15px 5px 15px 30px}
.joblist dt {font-size:14px; padding-bottom:5px}
.newc li.listall a{color:#0033CC;font-weight:bold;}
A.applink:hover {border: 2px dotted #DCE6F4;padding:2px;background-color:#ffff00;color:green;text-decoration:none}
A.applink       {border: 2px dotted #DCE6F4;padding:2px;color:#2F5BFF;background:transparent;text-decoration:none}
A.info          {color:#2F5BFF;background:transparent;text-decoration:none}
A.info:hover    {color:green;background:transparent;text-decoration:underline}
</style>

<script language="javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$(".leftmenu").bind("click",function(){
		$(".leftmenu").each(function(){
			$(this).removeClass("cur");
		});
		$(this).addClass("cur");
		
		$(".comp_info").each(function(){
			$(this).hide();
		});
		
		var id = $(this).attr("data-id");
		
		$(".c"+id).show();
	});
});
</script>

</head>
<body class="subpage">




<div class="wrap">
	<div class="header">
		<div class="logo"><a href="index.html" target="_self"><img src="<%=basePath %>css360/logo1.png" alt="360招聘"/></a></div><!--end logo-->
		<div class="nav">
			<ul>
				<jsp:include page="../../menu.jsp"></jsp:include>
			</ul>		
		</div><!--end nav-->
	</div><!--end header-->
    <div class="bnr">
    	<img src="<%=basePath %>css360/b008.png" />
    </div><!--end bnr-->    <div class="guide">		<a href="index.html" target="_self">首页</a> &gt;
		<a href="#" target="_self">关于我们</a>
	</div><!--end guide-->
	<div class="area1">
		<div class="left">
			<div class="menu">
				<ul>
				<li><a href="javascript:void(0)" class="leftmenu cur" data-id="1">公司介绍</a></li>
				<li><a href="javascript:void(0)" class="leftmenu" data-id="2">公司动态</a></li>
				<li><a href="javascript:void(0)" class="leftmenu" data-id="3">公司大事记</a></li>
				<li><a href="javascript:void(0)" class="leftmenu" data-id="4">企业文化</a></li>
			
				</ul>
			</div><!--end menu-->
		</div><!--end left-->
		<div class="right">

			<div class="comp_info c1">
				发件案件发链接啊路径
			</div>
			
			<div class="comp_info c2"  style="display: none;">
				<div class="list">
			<ul>




			<li><span>2015-02-16</span>
				<a href="News_getnews?id=7" title="我的新闻">
				我的新闻
				</a>
			</li>
		
		
			<li><span>2010-02-16</span>
				<a href="News_getnews?id=6" title="啊啊啊">
				啊啊啊啊啊
				</a>
			</li>
			
	</ul>

				
	</div>


			</div>
			
			
			<div class="comp_info c3"  style="display: none;">
				<div class="content">
				<div class="dsj">
					<div class="dsjt"></div>







                    <div class="text">


<dl class="list-date clearfix"><dt>01年12月</dt><dd>
开启免费时段。
</dd></dl>
	</div>














				</div><!--end dsj-->
			</div>


			</div>
			
			<div class="comp_info c4" style="display: none;">
				<div class="qywh">
				<ul>
				
				<li><strong>我们的愿景：</strong>成为全球最强大的公司</li>
				<li><strong>我们的使命：</strong>创造神器</li>
				</ul>
				<p><strong>用户至上：</strong></p>
				<p>为用户创造价值；</p>
				<p>坚决维护用户利益；</p>
				<p>尊重用户知情权与选择权；</p>
				<p>为用户提供简单易用的产品；</p>
			</div>
			
				
			</div>

		</div><!--end right-->
	</div></div><!--end wrap-->
<script src="<%=basePath %>css360/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>css360/main.js" type="text/javascript"></script>
</body>
</html>

<%!


String substr(String str, int length, String suffix) {
	if (str == null || str.length() == 0 || length < 1) {
		return str;
	}
	if (suffix == null) {
		suffix = "";
	}
	if (suffix.length() > 0 && length > suffix.length()) {
		length = length - suffix.length();
	} else {
		suffix = "";
	}

	int lencounter = 0;
	int index = 0;
	char[] strarray = str.toCharArray();
	try {
		for (; index < strarray.length; index++) {
			char ch = strarray[index];
			int step = 1;
			if (String.valueOf(ch).getBytes("GBK").length > 1) {
				step = 2;
			}
			if ((lencounter = lencounter + step) > length) {
				index--;
				break;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	if (index > 0 && index < str.length()) {
		str = str.substring(0, index) + suffix;
	}

	return str;
}
%>  