<%-- 
    Document   : error
    Created on : Oct 27, 2019, 11:07:20 AM
    Author     : murad_isgandar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>404 NOT FOUND!</title>
            <style>
                body {
                    background-color: #cccccc;
                }
                h1{
                    font-size: 40px;
                    text-align: center;
                    padding-top: 100px;
                }
                p{
                    text-align: center;
                }
                a{
                    text-decoration: none;
                }
            </style>
        </head>
        <body>
            <h1>404 NOT FOUND</h1>
            <p>Oops something went wrong!&nbsp;<br><br>
                Adminpage only seen by admin&nbsp;<br><br>
                If you see 404 error so
                you are user</p>
            <p>Please, go to userpage&nbsp;<a href="/userpage">Click</a></p>
        </body>
    </html>
</f:view>
