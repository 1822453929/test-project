<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>欢迎</title>
</head>
<body>
<h1>欢迎<%= session.getAttribute("username") %>!</h1>
<a href="LogoutServlet">注销</a>
</body>
</html>
