<%-- 
    Document   : userpage
    Created on : Sep 15, 2019, 8:44:05 PM
    Author     : murad_isgandar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <style>
            body{
                background: linear-gradient( #7f7fd5, #86a8e7, #91eae4);
            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script>
            function getById(id) {
                document.getElementById("getNameById").value = id;
            }
            function logoutPage() {
                alert("Do you sure?");
            }

            function informUser() {
                alert("Thank you for applying! Your information will be sent our database");
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
            <a class="navbar-brand" href="#">
                <img src="/images2.jpeg" style="width:150px; height:60px;border-radius: 10px;"   class="d-inline-block align-top">

            </a>
            <form action="/logout" method="POST">
                <button type="submit" class="btn btn-primary"
                        onclick="logoutPage()">
                    Log out</button>
            </form>
        </nav>

        <div class="row" id="verify" style="margin-left: 10px">
            <form class="col-md-3" method="POST" action="/userpage/add">
                <div class="form-group">
                    <label for="username">Username</label><br>
                    <input type="text" name="username" class="form-control"  placeholder="Must be your registered username" required="required">
                    <p style="color:red;">*It is required for authentication</p>
                </div>
                <div class="form-group">
                    <label for="password">Password</label><br>
                    <input type="text" name="password" class="form-control"  placeholder="Password" required="required">
                    <p style="color:red;">*It must be current password</p>
                </div>
                <div class="form-group">
                    <label for="mail">Mail</label><br>
                    <input type="text" name="mail" class="form-control"  placeholder="Mail" required="required">
                </div>
                <div class="form-group">
                    <label for="name">Name</label><br>
                    <input type="text" name="name" class="form-control"  placeholder="Name" required="required">
                </div>
                <div class="form-group">
                    <label for="surname">Surname</label><br>
                    <input type="text" name="surname" class="form-control"  placeholder="Surname" required="required">
                </div>
                <div class="form-group">
                    <label for="age">Age</label><br>
                    <input type="number" name="age" class="form-control"  placeholder="Age" required="required">
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Phone Number</label><br>
                    <input type="number" name="phoneNumber" class="form-control"  placeholder="+994557696787" required="required">
                </div>

                <div class="form-group">
                    Man<input type="radio" name="gender" value="Man">
                </div>
                <div class="form-group">
                    Woman <input type="radio" name="gender" value="Woman">
                </div>
                <div class="form-group">
                    Other<input type="radio" name="gender" value="Other">
                </div>

                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>    
                            <th>Country</th>    
                            <th>Date</th>
                            <th>Order</th>
                        </tr>
                    </thead>
                    <c:forEach items="${travelList}" var="item" varStatus="status">
                        <tbody>
                        <td>
                            ${status.count} 
                        </td>
                        <td>
                            ${item.countryname}
                        </td>
                        <td>
                            ${item.date}
                        </td>
                        <td>

                            <button type="button" class="btn btn-primary"
                                    onclick="getById('${item.id}')">
                                Choose</button>    
                        </td>
                    </c:forEach>
                    </tbody>
                </table>

                <input type="hidden" name="tour_id" id="getNameById"/>
                <input type="submit" class="btn btn-success" onclick="informUser()" value="Submit">


            </form>



        </div>

    </body>
</html>
