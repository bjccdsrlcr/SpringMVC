<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/17 0017
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>宝宝淘论坛登录</title>
</head>
<body>
        <c:if test="${!empty error}">
            <i color="red"><c:out value="${error}"></c:out></i>
        </c:if>
        ${encoding}
        <form action="<c:url value="/index.html"/>" method="post">
                用户名：
                <input type="text" name="userName">
                <br>
                密码：
                <input type="password" name="password">
                <br>
                <input type="submit" value="登录">
                <input type="reset" value="重置">
        </form>
</body>
</html>
