<%--
  Created by IntelliJ IDEA.
  User: burning-.-
  Date: 2015/6/27
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>播客首页</title>
    <script type="text/javascript">
        /*根据提交的表单项改变页面中的当前频道和排序标准的css属性，使其呈现为选中*/
       function selectChannelAndOrder(){
           var channelId="${channelId}";
           var channels=documnet.getElementById("channels").childNodes;
           for(i=0;i<channels.length;i++){
               if(channels[i].id=="channel_"+channelId){
                   channels[i].className="cur";
               }else{
                   channels[i].className="";
               }
           }
           var orderId="${orderId}";
           if(orderId!=1&&orderId!=2&&orderId!=3&&orderId!=4){
               if(i=orderId){
                   document.getElementById("order_"+i).classNam="cur";
               }else{
                   document.getElementById("order_"+i).className="";
               }
           }
       }
    </script>
</head>
<body onload="selectChannelAndOrder()">
    <%--<s:if test="#session.Logined_user==null">--%>
        <%--<a href="register_init.do">注册</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;--%>
        <%--<a href="login_init.do">登陆</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;--%>
    <%--</s:if>--%>
    <%--<s:else>--%>
        <%--<a href="login_logout.do">注销</a>--%>
        <%--<a href="upload_init.do">上传视频</a>--%>
    <%--</s:else>--%>
    <s:form action="main.do" method="post">
        <div>
           <s:if test="#session.logined_user==null">
              <a href="register_init.do">注册</a>&&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
               <a href="login_init.do">登陆</a>
           </s:if>
           <s:else>
               <a href="login_logout.do">注销</a>
               <a href="upload_init.do">上传视频</a>
           </s:else>
        </div>
        <div>
            <h3>视频分类</h3>
            <s:iterator value="all_channels" var="c">
                <h4 id="channel_${c.id}">
                    <a href="main.do?channelId=${c.id}&orderId=${orderId}">${c.name}</a>
                </h4>
            </s:iterator>
        </div>

        ${channel.name}频道
        <div>
            <ul>
                <li id="order_1">
                    <a href="main.do?channelId=${channelId}&orderId=1">最新发布</a>
                    <a href="main.do?channelId=${channelId}&orderId=2">最多播放</a>
                    <a href="main.do?channelId=${channelId}&orderId=3">评论最多</a>
                    <a href="main.do?channelId=${channelId}&orderId=4">最多好评</a>
                </li>
            </ul>
        </div>
        <select name="period">
            <option value="0">全部</option>
            <option value="1">本日</option>
            <option value="2">本月</option>
            <option value="3">本周</option>
        </select>
        <div>
           <s:iterator value="#page_bean.contents" var="video" status="st">
               <s:set name="duration" value="video.duration"/>
               <s:set name="minute" value="@com.spring.oa.util.CommonUtils@toInt(duration/60)"/>
               <s:set name="second" value="@com.spring.oa.util.CommonUtils@toInt(duration%60)"/>
               <dl<s:if test="#st.index%5==0">class="nomar"</s:if>>
                    <dt>
                        <a href="player_init.do?VideoId=${video.id}" target="_blank">
                            <img alt="${video.title}" src='<s:property value="@com.spring.oa.util.Const@UPLOAD_FOLDER"/>/${video.picFileName}.jpg'/>
                            <span>${minute}.${second}</span>
                        </a>
                    </dt>
                    <dd>
                        <h3>
                            <a href="player_init.do?videoId=${video.id}">${video.title}</a>
                        </h3>
                    </dd>
                    <dd>
                       发布:<s:date name="#video.uploadTime" format="yyyy-MM-dd"/>
                    </dd>
                    <dd>
                        播放:${video.playCount}
                    </dd>
                    <dd>
                        评论:${video.commentCount}
                    </dd>
               </dl>
           </s:iterator>
        </div>
        <div>
            <s:if test="#page_bean.currentPage==1">
                <span>首  页</span>
                <span>上一页</span>
            </s:if>
            <s:else>
                <a href="main.do?channelId=${channelId}&orderId=${orderId}&page=1">首  页</a>
                <a href="main.do?channelId=${channelId}&orderId=${orderId}&page=${page_bean.currentPage-1}">上一页</a>
            </s:else>
            <s:iterator begin="#page_bean.startPage" end="#page_bean.enPage" var="p">
                <s:if test="#p==#page_bean.currentPage">
                    <span class="cur">${p}</span>
                </s:if>
                <s:else>
                    <a href="main.do?channelId=${channelId}&orderId=${orderId}&page=${p}">${p}</a>
                </s:else>
            </s:iterator>
            <s:if test="#page_bean.currentPage==#page_bean.pageCount">
                <span>下一页</span>
                <span>下一页</span>
            </s:if>
            <s:else>
                <a href="main.do?channelId=${channelId}&orderId=${orderId}&page=${page_bean.currentPage+1}">下一页</a>
                <a href="main.do?channelId=${channelId}&orderId=${orderId}&page=${page_bean.pageCount}">末  页</a>
            </s:else>
        </div>
        <div>
            <p>Copyright@2005-2013 AHPU . All Rights Reserved</p>
            <p>版权所有 @AHPU 皖ICP备XXXXXX号</p>
        </div>
    </s:form>
</body>
</html>
