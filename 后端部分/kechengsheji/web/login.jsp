<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        form {
            width: 400px;
            margin: 100px auto;
            padding: 20px;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        input[type=text],
        input[type=password] {
            display: block;
            margin: 0 auto;
            margin-bottom: 10px;
            padding: 10px;
            width: 100%;
            font-size: 16px;
            line-height: 1.5;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            display: block;
            margin: 0 auto;
            padding: 10px 20px;
            background-color: #0079bf;
            color: #fff;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0062a0;
        }
    </style>
</head>
<body>
<form action="/LoginServlet" method="post">
    <h1>Login</h1>
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <button type="submit">Log in</button>
</form>
</body>
</html>
