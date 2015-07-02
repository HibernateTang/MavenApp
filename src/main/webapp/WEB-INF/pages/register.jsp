<%--
  Created by IntelliJ IDEA.
  User: burning-.-
  Date: 2015/6/27
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <script type="text/javascript">
        function changeVerificationCode(){
            var image=document.getElementById("verificationCodeImage");
            image.src="verification_code.do?random="+new Date().getTime();
        }
        function checkSubmit(){
            /*表单验证代码*/
            document.forms[0].submit();
        }
        function changeFace(facePic,faceId) {
            document.getElementById("MyFace").src="image/face"+facePic;
            document.getElementById("FaceId").valid=faceId;
        }
    </script>
    <title></title>
</head>
<body>
    <s:form method="post" action="register_register.do">
        <input type="hidden" name="faceId" value="${default_face.id}"/>
        请填写注册信息，若已有账号请<a href="login_init.do">点击登录</a>
        用户名:
        <s:textfield name="userName"/>
        <s:fielderror fieldName="user_name_exist_error"/>
        密&nbsp;&nbsp;码
        <s:password name="password"/>
        确认密码:
        <s:password name="password2"/>
        验证码:
        <s:textfield name="verificationCode"/>
        <img src="verification_code.do" title="看不清,换一张." onclick="changeVerificationCode()"/>
        <s:fielderror fieldName="verification_code_error"/>
        头&nbsp;&nbsp;像
        <img src="myFace" src="images/face/${default_face.picFileName}"/>
        <div id="bottom" onclick="checkSubmit()" style="cursor: hand"></div>
        <div>
            <s:iterator value="all_faces" var="face">
                <img src="images/face/${face.picFilename}"
                        onclick="changeFace('${face.picFilename}',${face.id})">
            </s:iterator>
        </div>
    </s:form>
</body>
</html>
