<%--
  Created by IntelliJ IDEA.
  User: burning-.-
  Date: 2015/6/26
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" %>
<html>
<head>
    <title>找不到页面</title>
    <script language="JavaScript" type="text/javascript">
        var second;
        function go(){
            second=document.getElementById("totalSecond").innerText;
            setInterval("redirect()",1000);
        }
        function redirect(){
            if(second<=0){
                location.href="main.do";
            }else{
                document.getElementById("totalSecond").innerText=--second;
            }
        }
    </script>
</head>
<body onload="go()">
    <h1>
        找不到页面:<span id="totalSecond">3</span>秒后返回
    </h1>
</body>
</html>
