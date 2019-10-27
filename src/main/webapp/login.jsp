<%-- 
    Document   : newjsf
    Created on : Oct 8, 2019, 10:42:16 AM
    Author     : murad_isgandar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Log in</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
        <style>
            body{
                color: #999;
                background: #f5f5f5;
            }
        </style>
        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {        
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .input-group-addon .fa {
                font-size: 18px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }

        </style>
    </head>
    <body>
        <div class="login-form">
            <form action="/login" method="POST">
                <h2 class="text-center">Log In</h2>   
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input type="text" name="username" class="form-control" placeholder="Username" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        <input type="password" name="password" class="form-control" placeholder="Password" required="required">
                    </div>
                </div>        
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>
                <div class="clearfix">
                    <p class="text-center small">Don't have an account! <a href="/registration">Sign up here</a>.</p>
                </div>
            </form>
        </div>
        <div class="clearfix">
            <p class="text-center big" style="color:red;">${param.error?"Invalid inputs! Or You haven't permitted by admin.Please, waiting for permission":""}</p>
        </div>
    </body>
</html>                                       		                            