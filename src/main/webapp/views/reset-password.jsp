<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt lại mật khẩu</title>
</head>
<body>
    <h2>Đặt lại mật khẩu</h2>
    <form action="web-reset-password" method="post">
        <input type="hidden" name="token" value="${param.token}">
        Mật khẩu mới: <input type="password" name="newPassword" required>
        <input type="submit" value="Đặt lại mật khẩu">
    </form>
</body>
</html>
