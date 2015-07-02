<%--
  Created by IntelliJ IDEA.
  User: burning-.-
  Date: 2015/6/29
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>${video.tilte}</title>
</head>
<body>
    <s:if test="#session.logined_user==null">
        <a href="register_init.do">注册</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
        <a href="login_init.do">登陆</a>
    </s:if>
    <s:else>
        <a href="login_out.do">注销</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
        <a href="upload_init.do">上传视频</a>
    </s:else>
    ${video.channel.name}频道
    <h1>${video.title}</h1>
    <object classid="clsid:D27CDB6E-AE6D-11cf-968B-444553540000">
        <param name="movie" value="FlvPlayer.swf">
        <param name="FlashVars" value='vcastr_file=<s:property value="@com.spring.oa.util.Const@UPLOAD_FOLDER"/>/${video.serverFilename}.flv'>
        <embed src="FlvPlayer.swf" flashvars='vcastr_file=<s:property value="@com.spring.oa.util.Const@UPLOAD_FOLDER"/>${video.serverFileName}.flv'/>
    </object>
    <a href="player_ding.do?videoId=${videoId}">${video.goodCommentCount}</a>
    <a href="player_cai.do?videoId=${videoId}">${video.BadCommentCount}</a>

    <a href="javascript:void(0);">收藏</a>
    <a href="javascript:void(0);">下载</a>
    播放:${video.playCount}
    <a href="#video.uploadTime" format="yyyy-MM-dd"/>上传

    <s:form action="player_commnent.do" method="post">
        <input type="hidden" name="videoId" value="${video.id}">
        <s:textarea name="commentContent"/>
        <span onclick="submit();">发表评论</span>
    </s:form>
    <div>共${video.commentCount}条评论</div>
    <s:iterator value="comments" var="comment">
        <img src="images/face/${comment.user.face.picFileName}"/>
        ${comment.user.name}
        <p>${comment.content}</p>
        <s:date name="#comment.time" format="yyyy-MM-dd HH:mm:ss"/>
    </s:iterator>
</body>
</html>
