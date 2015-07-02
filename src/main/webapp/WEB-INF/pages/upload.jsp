<%--
  Created by IntelliJ IDEA.
  User: burning-.-
  Date: 2015/6/27
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>上传视频</title>
    <script type="text/javascript">
        function upload(){
            document.form[0].submit();
        }
    </script>
</head>
<body>
    <h3>上传视频</h3>
    <s:form action="upload_upload.do" method="post" enctype="multipart/form-data">
        文件:
        <s:file name="video"/>

        标题:
        <s:textfield name="title"/>

        简介:
        <s:textarea name="description"/>

        频道:
        <s:select name="channelId" list="all_channels" listKey="id" listvalue="name"/>

        标签:
        <s:textfield name="tags"/>

        <img src="images/upload.jpeg" onclick="upload()"/>
    </s:form>
</body>
</html>
