<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Game Library</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/comm.css">
</head>
<body>
<div class="col-md-4 col-md-offset-4" style="margin-top: 40px">
    <h1>Your Game Library</h1>
    <a class="btn btn-default" role="button" href="index.html">Back Home</a>
    <div>
        <c:forEach items="${requestScope.games}" var="game">
            <div class="row" style="display: flex;flex-direction: row;align-items: center;margin: 10px 0;background-color: #ececec;border-radius: 10px;padding: 10px">
                <div class="col-md-4">${game.gameName}</div>
                <div class="col-md-2"></div>
                <a class="btn btn-default" href="/removeGame?gameName=${game.gameName}" role="button">Remove</a>
            </div>
        </c:forEach>
    </div>
    <div style="color: red">${error}</div>
    <form action="/addGame" method="get" class="col-md-8 col-md-offset-4" style="margin-top: 40px;display: flex;flex-direction: row">
        <div class="form-group">
            <label class="sr-only" for="gameName">Game Name</label>
            <select class="form-control" name="gameName" id="gameName">
                <c:forEach items="${requestScope.allGames}" var="game">
                    <option value="${game.gameName}">${game.gameName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Add</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>