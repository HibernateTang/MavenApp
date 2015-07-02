<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: burning-.-
  Date: 2015/6/27
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>登陆</title>
    <script type="text/javascript">
        function changeVerificationCode(){
            var image=document.getElementById("verificationCodeImage");
            image.src="verification_code.do?random="+new Date().getTime();
        }
        function checkSubmit(){
            document.form[0].submit();
        }
    </script>
</head>
<body>
    <s:form method="post" action="login_login.do">
        登陆后才能上传视频和评论，若没有账号请<a href="register_init.do">单击登陆</a>

        用户名:
        <s:textfield name="userName"/>
        <s:fielderror fieldName="invalid_user_error"/>

        密&nbsp;&nbsp;码
        <s:password name="password"/>

        验证码:
        <s:textfield name="verificationCode"/>
        <img src="verification_code.do" title="看不清，换一张。" onclick="changeVerificationCode()"/>
        <s:fielderror fieldName="verification_code_error"/>

        <div id="bottom" onclick="checkSubmit()" style="cursor: hand"></div>
    </s:form>
</body>
</html>
