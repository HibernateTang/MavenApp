<%--
  Created by IntelliJ IDEA.
  User: burning-.-
  Date: 2015/6/27
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.spring.oa.util.Const" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%@ page contentType="image/jpeg" import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"%>
<%!
    Random random=new Random();//构造Random对象
    Color getRandomColor(int begin,int end){//得到范围内的随机颜色
        int range=end-begin;
        int r=begin+random.nextInt(range);
        int g=begin+random.nextInt(range);
        int b=begin+random.nextInt(range);
        return new Color(r,g,b);
    }
%>
<%
    /*设置浏览器不缓存页面*/
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires",0);
    /*生成4位随机验证码*/
    String code="";
    for (int i = 0; i <4 ; i++) {
       code+=String.valueOf(random.nextInt(10));
    }
    /*将验证码存入session*/
    session.setAttribute(Const.KEY_VERIFICAITON_CODE,code);
    int w=55;
    int h=20;
    /*在内存中创建图片对象*/
    BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);//w:图片的宽度h:图片的高度BufferedImage:设置图片的颜色表示方法为RGB
    Graphics g=image.getGraphics();
    g.setColor(getRandomColor(200,250));//设置画笔颜色
    g.fillRect(0, 0, w, h);//绘制矩形区域
    g.setFont(new Font("serif", Font.CENTER_BASELINE, 16));//设置字体
    /*绘制100条随机干扰线*/
    for (int i = 0; i <100 ; i++) {
        g.setColor(getRandomColor(160,200));
        int x1=random.nextInt(w);
        int x2=random.nextInt(h);
        int y1=random.nextInt(12);
        int y2=random.nextInt(12);
        g.drawLine(x1, y1, x2, y2);
    }
    int rgb=random.nextInt(256);
    g.setColor(new Color(rgb, rgb, rgb));
    for (int i = 0; i <100 ; i++) {
        String s=code.substring(i,i+1);
        g.drawString(s,13*i+6,16);//绘制字符串
    }
    g.dispose();
    /*将图片写入页面*/
    try {
        ImageIO.write(image,"JPEG",response.getOutputStream());
    }catch (Exception e){
    }
    out.clear();
    out=pageContext.pushBody();
%>
<html>
    <head>
        <title></title>
    </head>
    <body>

    </body>
</html>
