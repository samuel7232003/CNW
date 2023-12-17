<%@ page import="ModelBean.UserBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ModelBean.TourBean" %><%--
  Created by IntelliJ IDEA.
  User: Le Viet Thanh
  Date: 12/17/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="./template/titketInfor.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@300;400;700&family=Bodoni+Moda:ital,wght@0,400;0,500;0,600;0,700;0,800;1,400;1,500;1,600;1,700;1,800&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/5175756225.js" crossorigin="anonymous"></script>
    <title>Đi đến Hội An</title>
</head>
<body>
<div class="header">
    <div>
        <a href="./home.jsp">Trang chủ</a>
        <a href="${pageContext.request.contextPath}/posterController" >Bài viết</a>
        <a href="${pageContext.request.contextPath}/tourController" class="bold-underline">Thông tin vé</a>
    </div>
    <%
        UserBean user = (UserBean) request.getAttribute("user");
        if(user!=null){
    %>
    <a class="login"><%= user.getName() %></a>
    <%
    } else {
    %>
    <a href="${pageContext.request.contextPath}/loginController" class="login">Đăng nhập</a>
    <%}%>
</div>
<div class="main">
    <div class="title-main">
        <p>Đi đến...</p>
        <img class="img" src="./image/icon.png">
        <span></span>
    </div>
    <div class="menu">
        <a class="selected" href="">Đặt vé mới</a>
        <a class="" href="">Lịch sử đặt vé</a>
    </div>
    <div class="list-titket">
        <%
            ArrayList<TourBean> tourBeans = (ArrayList<TourBean>) request.getAttribute("listTour");
            for(int i=0; i<tourBeans.size();i++){
                TourBean tour = tourBeans.get(i);

        %>
        <div class="item">
            <img src="./image/image<%=i+1%>.jpg" alt="">
            <div class="text">
                <p class="title"><%=tour.getTourName()%></p>
                <p class="infor"><%=tour.getTourDetail()%></p>
                <p class="price"><%=tour.getTourPrice()%> / 1 vé</p>
            </div>
            <div class="detail">
                <i class="fa-solid fa-cart-shopping"></i>
            </div>
        </div>
        <%}%>

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
