<%--
  Created by IntelliJ IDEA.
  User: burning-.-
  Date: 2015/6/29
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>出错了</title>
</head>
<body>
    <h1>
        发生错误:
        <span style="color: #FF0000">
            <s:property value="%{exception.message}"/>
        </span>
    </h1>
    <hr/>
    <h3>详细信息</h3>
    <p>
        <s:property value="%{exceptionStack}"/>
    </p>
</body>
</html>
