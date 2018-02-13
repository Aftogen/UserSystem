<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 13.02.2018
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="userFromServer" method="post" action="/user-system/users/check">
    <spring:input path="name"/>
    <spring:input path="password"/>
    <spring:button>check user</spring:button>
</spring:form>
</body>
</html>