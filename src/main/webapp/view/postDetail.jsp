<%@ page import="ModelBean.PostBean" %><%--
  Created by IntelliJ IDEA.
  User: Le Viet Thanh
  Date: 12/17/2023
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <link rel="stylesheet" href="./template/postDetail.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@300;400;700&family=Bodoni+Moda:ital,wght@0,400;0,500;0,600;0,700;0,800;1,400;1,500;1,600;1,700;1,800&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
  <title>Viết về Hội An</title>
</head>
<body>
<div class="header">
  <div>
    <a href="./home.jsp">Trang chủ</a>
    <a href="${pageContext.request.contextPath}/posterController" class="bold-underline">Bài viết</a>
    <a href="./titketInfor.jsp">Thông tin vé</a>
  </div>
  <a href="./login.jsp" class="login">Đăng nhập</a>
</div>
<div class="main">
  <%
    PostBean post = (PostBean) request.getAttribute("post");
    String num = (String) request.getAttribute("num");
  %>
  <img src="./image/image<%=num%>.jpg" alt="">
  <div class="text">
    <p class="title"><%= post.getPostName() %></p>
    <p class="content"><%= post.getPostDetail() %></p>
  </div>
</div>
<div class="footer">
  <p class="title">Thông tin liên hệ:</p>
  <span></span>
  <p>Tel: 0232323232</p>
  <p>Email: hoiantrip@gmail.com</p>
</div>
</body>
</html>
