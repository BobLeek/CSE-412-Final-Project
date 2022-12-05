<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Game Search Result</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/comm.css">
</head>
<body>
<div class="col-md-4 col-md-offset-4" style="margin-top: 40px">
    <h1>Game Search Result</h1>
    <div>
        <a class="btn btn-default" role="button" href="index.html">Back Home</a>
        <% if( ((List)request.getAttribute("users")).size() == 0) {%>
             <h3>Sorry, nobody has same game in the library.</h3>
        <% }  else {%>
            <div class="row glyphicon-align-left">
                <div class="col-md-6" style="color: red">${error}</div>
            </div>

            <c:forEach items="${requestScope.users}" var="user">
                <div class="row" style="display: flex;flex-direction: row;align-items: center;margin: 10px 0;background-color: #ececec;border-radius: 10px;padding: 10px">
                    <div class="col-md-4">${user.username}</div>
                    <div class="col-md-2"></div>
                    <a class="btn btn-default" href="/addFriend?email=${user.email}" role="button">Add</a>
                </div>
            </c:forEach>
        <% }%>
    </div>
</div>
</body>
</html>