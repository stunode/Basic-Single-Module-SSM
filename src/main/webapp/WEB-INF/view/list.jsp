<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/5/22
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Insert title here</title>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script type="text/javascript">
    $(function(){
      $(".delete").click(function(){
        var href = $(this).attr("href");
        $("form").attr("action", href).submit();
//提交终止符，防止多次提交
        return false;
//      alert("Hello jquery")
      });
    })
  </script>
</head>
<body>
<%--post请求转化删除请求--%>
<form action="" method="POST">
  <input type="hidden" name="_method" value="DELETE"/>
</form>

<c:if test="${empty requestScope.employees }">
  没有任何员工信息.
</c:if>
<c:if test="${!empty requestScope.employees }">
  <table border="1" cellpadding="10" cellspacing="0">
    <tr>
      <th>ID</th>
      <th>LastName</th>
      <th>Email</th>
      <th>Gender</th>
      <th>Department</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>

    <c:forEach items="${requestScope.employees }" var="emp">
      <tr>
        <td>${emp.id }</td>
        <td>${emp.lastName }</td>
        <td>${emp.email }</td>
        <td>${emp.gender == 0 ? 'Female' : 'Male' }</td>
        <td>${emp.department.departmentName }</td>
        <td><a href="emp/${emp.id}">Edit</a></td>
        <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<br><br>

<a href="emp">Add New Employee</a>

</body>
</html>
