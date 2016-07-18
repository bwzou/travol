<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="randomPic.RandomNumUtil"%>
<%@ page language="java" contentType="image/jpeg"
    pageEncoding="UTF-8"%>
    <%
    response.setHeader("Pragma","no-cache");
    response.setHeader("Catch-Control", "no-catch");
    response.setDateHeader("Expires", 0);
    
    RandomNumUtil rand=RandomNumUtil.Instance();
    ByteArrayInputStream image=rand.getImage();
    String str=rand.getString();
    session.setAttribute("random", str);
    ImageIO.write(ImageIO.read(image),"jpeg",response.getOutputStream());
    out.clear();
    out=pageContext.popBody();
    %>