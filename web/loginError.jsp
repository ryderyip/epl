<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login</title>
  </head>
  <body>
    <p>Incorrect Password</p>
    <p>
        <%
            out.println("<a href=\"" + request.getContextPath() + "/login.jsp\">Login again</a>");
        %>
    </p>
  </body>
</html>