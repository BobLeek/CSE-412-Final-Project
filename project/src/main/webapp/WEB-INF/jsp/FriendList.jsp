<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Friend List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/comm.css">
</head>
<body>
<div class="col-md-4 col-md-offset-4" style="margin-top: 40px">
    <h1>Your Friend List</h1>
    <a class="btn btn-default" role="button" href="index.html">Back Home</a>
    <div >
        <c:forEach items="${requestScope.friends}" var="user">
            <div class="row" style="display: flex;flex-direction: row;align-items: center;margin: 10px 0;background-color: #ececec;border-radius: 10px;padding: 10px">
                <div class="col-md-4">${user.username}</div>
                <div class="col-md-2"></div>
                <a class="btn btn-default" href="/removeFriend?email=${user.email}" role="button">Remove</a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>