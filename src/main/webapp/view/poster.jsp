<%@ page import="java.util.ArrayList" %>
<%@ page import="ModelBean.PostBean" %>
<%@ page import="ModelBean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Le Viet Thanh
  Date: 12/15/2023
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Viết về Hội An</title>
    <link rel="stylesheet" href="./template/poster.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@300;400;700&family=Bodoni+Moda:ital,wght@0,400;0,500;0,600;0,700;0,800;1,400;1,500;1,600;1,700;1,800&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
</head>
<body>
<div class="header">
    <div>
        <a href="./view/home.jsp">Trang chủ</a>
        <a href="${pageContext.request.contextPath}/posterController" class="bold-underline">Bài viết</a>
        <a href="${pageContext.request.contextPath}/tourController">Thông tin vé</a>
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
        <p>Viết về...</p>
        <img class="img" src="./image/icon.png">
        <span></span>
    </div>
    <div class="list-posts">
        <%
            ArrayList<PostBean> postBeans = (ArrayList<PostBean>) request.getAttribute("listPost");
            for (int i = 0; i<postBeans.size(); i++){
                PostBean post = postBeans.get(i);
        %>
            <div class="item">
                <img src="./image/image<%=i+1%>.jpg" alt="">
                <div class="text">
                    <p class="title"><%= post.getPostName() %> </p>
                    <p class="content"><%= post.getHiredContent() %></p>
                    <a href="${pageContext.request.contextPath}/posterDetailController?id=<%=i+1%>" class="seemore">Xem thêm</a>
                </div>
            </div>
        <% } %>
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