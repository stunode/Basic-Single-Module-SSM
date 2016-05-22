<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/view/common/tagPage.jsp" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>首页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<!--
		模拟修改操作
		1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
		2. 密码不能被修改.
		3. 表单回显, 模拟操作直接在表单填写对应的属性值
	-->
<form action="/Basic-Single-Module-SSM/testModelAttribute" method="Post">
    <input type="text" name="id" value="1"/>
    username: <input type="text" name="username" value="Tom"/>
    <br>
    password: <input type="text" name="password" value="123456"/>
    <br>
    email: <input type="text" name="email" value="tom@atguigu.com"/>
    <br>
    age: <input type="text" name="age" value="12"/>
    <br>
    <input type="submit" value="Submit"/>
</form>
<br><br>
<%--SessionAttributes测试--%>
<%--<a href="/Basic-Single-Module-SSM/testSessionAttributes">Test SessionAttributes</a>--%>
<%--<br><br>--%>
<a href="/Basic-Single-Module-SSM/emps">List All Employees</a>
<br><br>

<%--<h2>--%>
    <%--<form action="/Basic-Single-Module-SSM/testMethod" method="post">--%>
        <%--<input type="submit" value="submit"/>--%>
    <%--</form>--%>
    <%--<a href="/Basic-Single-Module-SSM/testAntPath/213123/abc" target="_blank">testpath</a>--%>
    <%--<a href="/Basic-Single-Module-SSM/testRequestMapping" target="_blank">Hello world</a>--%>
<%--</h2>--%>


<%--<a href="/Basic-Single-Module-SSM/testRedirect">Test Redirect</a>--%>
<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testView">Test View</a>--%>
<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testViewAndViewResolver">Test ViewAndViewResolver</a>--%>
<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testMap">Test Map</a>--%>
<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testModelAndView">Test ModelAndView</a>--%>
<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testServletAPI">Test ServletAPI</a>--%>
<%--<br><br>--%>

<%--<form action="/Basic-Single-Module-SSM/testPojo" method="post">--%>
    <%--username: <input type="text" name="username"/>--%>
    <%--<br>--%>
    <%--password: <input type="password" name="password"/>--%>
    <%--<br>--%>
    <%--email: <input type="text" name="email"/>--%>
    <%--<br>--%>
    <%--age: <input type="text" name="age"/>--%>
    <%--<br>--%>
    <%--city: <input type="text" name="address.city"/>--%>
    <%--<br>--%>
    <%--province: <input type="text" name="address.province"/>--%>
    <%--<br>--%>
    <%--<input type="submit" value="Submit"/>--%>
<%--</form>--%>

<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testCookieValue">Test CookieValue</a>--%>
<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testRequestHeader">testRequestHeader</a>--%>

<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testRequestParam?username=atguigu&age=10">Test ParamsAndHeaders</a>--%>
<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testPathVariable/1">Test PathVariable</a>--%>

<%--<br><br>--%>

<%--<form action="/Basic-Single-Module-SSM/testRest/1" method="post">--%>
    <%--<input type="hidden" name="_method" value="PUT"/>--%>
    <%--<input type="submit" value="TestRest PUT"/>--%>
<%--</form>--%>
<%--<br><br>--%>

<%--<form action="/Basic-Single-Module-SSM/testRest/1" method="post">--%>
    <%--<input type="hidden" name="_method" value="DELETE"/>--%>
    <%--<input type="submit" value="TestRest DELETE"/>--%>
<%--</form>--%>
<%--<br><br>--%>

<%--<form action="/Basic-Single-Module-SSM/testRest" method="post">--%>
    <%--<input type="submit" value="TestRest POST"/>--%>
<%--</form>--%>
<%--<br><br>--%>

<%--<a href="/Basic-Single-Module-SSM/testRest/1">Test Rest Get</a>--%>
<%--<br><br>--%>

<a href="/sysUserController/showUserToJspById/1" target="_blank">查询用户信息并跳转到一个JSP页面</a>

<br>

<a href="/sysUserController/showUserToJSONById/1" target="_blank">查询用户信息并直接输出JSON数据</a>

</body>
</html>
