<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/comm.css">
</head>
<body>

<div class="col-md-4 col-md-offset-4" style="margin-top: 200px">
    <form class="form-inline" action="/searchGame" method="get">
        <div class="form-group">
            <label class="sr-only" for="game">Game Name</label>
            <input type="text" name="game" class="form-control" id="game" placeholder="Game Name">
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Search</button>
            </div>
        </div>
    </form>

    <div class="row" style="margin: 40px 0">
        <div class="col-md-2"><a class="btn btn-default" href="FriendList.html" role="button">Friend List</a></div>
        <div class="col-md-1"></div>
        <div class="col-md-2"><a class="btn btn-default" href="GameLibrary.html" role="button">Game Library</a></div>
    </div>
</div>
</body>
</html>