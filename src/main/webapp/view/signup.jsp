<%--
  Created by IntelliJ IDEA.
  User: Le Viet Thanh
  Date: 12/17/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <link rel="stylesheet" href="../template/signup.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@300;400;700&family=Bodoni+Moda:ital,wght@0,400;0,500;0,600;0,700;0,800;1,400;1,500;1,600;1,700;1,800&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
  <title>Đăng ký</title>
</head>
<body>
<div class="header">
  <div>
    <a href="./home.jsp">Trang chủ</a>
    <a href="./poster.jsp" class="bold-underline">Bài viết</a>
    <a href="./titketInfor.jsp">Thông tin vé</a>
  </div>
  <a href="./login.jsp" class="login">Đăng nhập</a>
</div>
<div class="main">
  <form action="" class="login-form">
    <p class="title">Đăng ký</p>
    <span></span>
    <input type="text" placeholder="Họ và tên...">
    <input type="text" placeholder="Tên đăng nhập...">
    <input type="text" placeholder="Mật khẩu...">
    <input type="text" placeholder="Xác nhận mật khẩu...">
    <p class="error">Tên đăng nhập không tồn tại!</p>
    <input class="submit" type="button" value="ĐĂNG KÝ">
  </form>
</div>
</body>
</html>