<%-- 
    Document   : adminlogin
    Created on : Sep 15, 2019, 6:06:02 PM
    Author     : murad_isgandar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin Page</title>
        <style>
            body{
                background: linear-gradient( #7f7fd5, #86a8e7, #91eae4);
            }
            table {
                border-collapse: collapse;
            }

            table, th, td {
                border: 1px solid black;
            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script>
            function getByIdDelete(id) {
                document.getElementById("getNameByIdForDelete").value = id;
            }

            function getByIdUpdate(id) {
                document.getElementById("getNameByIdForUpdate").value = id;
            }

            function logoutPage() {
                alert("Do you sure?");
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
            <a class="navbar-brand" href="#">
                <img src="/images2.jpeg" style="width:100px; height:60px;border-radius: 10px;"class="d-inline-block align-top">

            </a>
            <form action="/users" method="GET">
                <a class="btn btn-primary" href="/users" target="blank" role="button">User Management</a>
            </form>
            <form action="/logout" method="POST">
                <button type="submit" class="btn btn-primary"
                        onclick="logoutPage()">
                    Log out</button>
            </form>

        </nav>


        <div class="modal" id="delete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="/adminpage/delete" method="POST">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Delete</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            Are you sure to delete?
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <input type="hidden" name="id" id="getNameByIdForDelete"/>
                            <input type="submit" class="btn btn-success" value="Yes">
                            <input type="submit" class="btn btn-danger" data-dismiss="modal" value="Cancel">
                        </div>  
                    </form>
                </div>
            </div>
        </div>

        <div class="modal" id="update">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="/adminpage/update" method="POST">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Edit</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="row" style="margin-left: 10px">

                                <div class="form-group">
                                    <label for="countryname">Name</label><br>
                                    <input type="text" name="countryname" class="form-control"  placeholder="Countryname">

                                    <label for="date">Date</label><br>
                                    <input type="text" name="date" class="form-control"  placeholder="DD-MM-YY">
                                </div>


                            </div>

                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <input type="hidden" name="id" id="getNameByIdForUpdate"/>
                            <input type="submit" class="btn btn-success" value="Yes">
                            <input type="submit" class="btn btn-danger" data-dismiss="modal" value="Cancel">
                        </div>  
                    </form>
                </div>
            </div>
        </div>

        <div class="row" style="margin-left: 10px">
            <form class="col-md-3" method="POST" action="/adminpage/add">
                <div class="form-group">
                    <label for="name">Name</label><br>
                    <input type="text" name="countryname" class="form-control"  placeholder="Countryname">
                </div>
                <div class="form-group">
                    <label for="surname">Date</label><br>
                    <input type="text" name="date" class="form-control"  placeholder="DD-MM-YY">
                </div>

                <button type="submit" class="btn btn-success" >Add</button>
            </form>
        </div>
        <br>

        <div class="row" style="margin-left: 10px">
            <form class="col-md-3" method="GET" action="/adminpage/search">
                <div class="form-group">
                    <label for="name">Name</label><br>
                    <input type="text" name="countryname" class="form-control"  placeholder="Countryname">
                </div>
                <div class="form-group">
                    <label for="surname">Date</label><br>
                    <input type="text" name="date" class="form-control"  placeholder="DD-MM-YY">
                </div>

                <button type="submit" class="btn btn-success" >Search</button>
            </form>
        </div>
        <br>

        <div class="col-">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Countryname</th>
                        <th>Date</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <c:forEach items="${travelList}" var="item" varStatus="status">
                    <tbody>

                        <tr>
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
                                <button class="btn btn-warning" data-toggle="modal" data-target="#update"
                                        onclick="getByIdUpdate(${item.id})"
                                        >
                                    <i class="fa fa-pencil" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-danger" data-toggle="modal" data-target="#delete"
                                        onclick="getByIdDelete(${item.id})"
                                        >
                                    <i class="fa fa-trash" aria-hidden="true"></i>
                                </button>

                            </td>

                        </tr>
                    </tbody>
                </c:forEach>
            </table> 
        </div>
    </body>
</html>
