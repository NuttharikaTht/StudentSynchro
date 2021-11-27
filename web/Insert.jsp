<%-- 
    Document   : Insert
    Created on : Nov 21, 2021, 2:32:05 AM
    Author     : aomms
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert Student</h1>
        <form name="Student" method="POST">
            ID : <input type="text" name="id" value="" size="5" />
            <br>
            <br>
            Name : <input type="text" name="name" value="" size="50" />
            <br>
            <br>
            GPA : <input type="text" name="gpa" value="" size="4" />
            <br>
            <br>
            <input type="submit" value="Insert" formaction="Insert" /> 
        </form>
        <a href="index.html"><h3>Back</h3></a>
    </body>
</html>
