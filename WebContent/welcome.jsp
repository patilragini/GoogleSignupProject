<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body background="lavender">
    <h3>Login successful!!!</h3>
    <h4>
        Hello,
        <%=session.getAttribute("name")%></h4><br>
         <form action="logoutServlet" method="post">
         <td style="width: 129px; "><input type="submit" value="logout" style="width: 81px; "/>
         </td>
         </form>
</body>
</html>