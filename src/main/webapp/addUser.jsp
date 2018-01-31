<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="user/addUser" method="post">
        UserName:<input type="text" name="urUserName"/><br/>
        Name:<input type='password' name="urPassword"/><br/>
        Age:<input type="text" name="urAge"/><br/>
        <input type="submit" value="提交"/>
        </form>
    </body>
</html>
