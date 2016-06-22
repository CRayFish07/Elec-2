<%@page import="com.yan.util.StringUtil"%>
<%@page import="org.apache.struts2.components.Include"%>
<%@page import="com.yan.util.ColUtil"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ include file="/cookie.jsp" %>

<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/buttonstyle.css" type="text/css" rel="stylesheet">
<LINK href="${pageContext.request.contextPath}/css/MainPage.css" type="text/css" rel="stylesheet">
<script type='text/javascript' src='${pageContext.request.contextPath}/script/pub.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath}/script/validate.js'></script>
<SCRIPT type="text/javascript">
function ini(){
   document.all.name.focus();
}
function check(){
    var theForm = document.forms[0];
    if(!checkNull(theForm.name))
		{
			alert("请输入用户名");
			theForm.name.focus(); 
			return false;
		} 
	if(Trim(theForm.name.value)==""){
			alert("请输入用户名");
			theForm.name.focus();
			return false;
	    }
}

//切换验证码
function changeImage() {
	document.getElementById("checkWordImage").src = "${pageContext.request.contextPath }/image.jsp?timeStamp="+new Date().getTime();
}
</SCRIPT>
<STYLE type=text/css>
BODY { margin: 0px; }
FORM {
	MARGIN: 0px; BACKGROUND-COLOR: #ffffff
} 

#checkWord {
	WIDTH:50px;
}
</STYLE>
<title>国家电力监测中心</title>
</head>
<body onload="ini()">
<form action="${pageContext.request.contextPath}/menu/elecMenuAction_home.do" method="post" onsubmit="return check();">
<table border="0" width="100%" id="table1" height="532" cellspacing="0" cellpadding="0" >
	<tr>
		<td>　</td>
	</tr>
	<tr>
		<td height="467">
		<table border="0" width="1024" id="table2" height="415" cellspacing="0" cellpadding="0" >
		<br><br><br><br><br>
			<tr>
				<td width=12%></td>
				<td align=center background="${pageContext.request.contextPath}/images/index.jpg">
				<table border="0" width="98%" id="table3" height="412" cellspacing="0" cellpadding="0">
					<tr height=122>
						<td colspan=2></td>
					</tr>
					<tr>
						<td height="313" width="73%"></td>
						<td height="99" width="27%">
							<table border="0" width="70%" id="table4">
								<tr>
									<s:fielderror name="error" ></s:fielderror>
								</tr>
								<%
									String name = findCookie(request, "account");
								%>
								<tr>
									<td width="100"><img border="0" src="${pageContext.request.contextPath}/images/yonghu.gif" width="84" height="20"></td>
									<td><input type="text" name="name" width="80px" value='<%= name %>'  maxlength="25" /></td>
								</tr>
								<tr>
									<td width="100"><img border="0" src="${pageContext.request.contextPath}/images/mima.gif" width="84" height="20"></td>
									<td width="100"><input type="password" width="80px" value=""  maxlength="40"></input></td>
								</tr>
								<tr>
									<td width="100"><img border="0" src="${pageContext.request.contextPath}/images/check.jpg" width="84" height="20"></td>
									<td>
										<input name="checkWord" id="checkWord" type="text" maxlength="4" style="vertical-align:middle;" />
										<img id="checkWordImage" alt="点击切换" src="${pageContext.request.contextPath }/image.jsp" width="55px" height="20px" style="vertical-align:middle;margin-left: 2px; cursor: hand" onclick="changeImage()" />
									</td>
								</tr>
								<tr>
									<td width="100"></td>
									<td width="200"><input type="submit" class=btn_mouseout onmouseover="this.className='btn_mouseover'" onmouseout="this.className='btn_mouseout'" value="登   录" name="huifubtn"></td>
								</tr>
								<tr>
									<td></td><td>
									<% if(StringUtil.isEmpty(name)) {%>
										<input name="remeberMe" type="checkbox" value="yes"/>
									<% } else { %>
										<input name="remeberMe" type="checkbox" value="yes" checked/>
									<% } %>
									<font size="2"><b>记住帐号</b></font></td>
								</tr>
							</table>
						</td>
					</tr>
					
					</table>
				</td>
				<td width=13%></td>
			</tr>
			<tr>
		      <td align="center" colspan=3>&nbsp;</td>
	        </tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
