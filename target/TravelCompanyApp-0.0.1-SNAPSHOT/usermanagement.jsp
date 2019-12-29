<%-- 
    Document   : userpermission
    Created on : Oct 21, 2019, 11:40:07 PM
    Author     : murad_isgandar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>User management</title>
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
                b{
                    text-align: center;
                }
            </style>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
            <script>

                function getByIdUpdate(id) {
                    document.getElementById("getByIdForUpdate").value = id;
                }

            </script>
        </head>
        <body>
            <div class="modal" id="update">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/adminpage/users/access" method="POST">
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Manage</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                Are you sure to change access of selected user?
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <input type="hidden" name="id" id="getByIdForUpdate"/>
                                <input type="submit" class="btn btn-success" value="Yes">
                                <input type="submit" class="btn btn-danger" data-dismiss="modal" value="Cancel">
                            </div>  
                        </form>
                    </div>
                </div>
            </div>

            <br>
            <div>
                <h1 style="text-align:center;">Active Users</h1>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Username</th>
                            <th>İnactivate</th>
                        </tr>
                    </thead>
                    <c:forEach items="${trueEnabled}" var="item" varStatus="status">
                        <tbody>

                            <tr>
                                <td>
                                    ${status.count}  
                                </td>
                                <td>
                                    ${item.username}
                                </td>
                                <td>
                                    <button class="btn btn-warning" data-toggle="modal" data-target="#update"
                                            onclick="getByIdUpdate(${item.id})"
                                            >
                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                    </button>
                                </td>

                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>

            <div>
                <h1 style="text-align:center;">Inactive Users</h1>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Username</th>
                            <th>Activate</th>
                        </tr>
                    </thead>
                    <c:forEach items="${falseEnabled}" var="item" varStatus="status">
                        <tbody>

                            <tr>
                                <td>
                                    ${status.count}  
                                </td>
                                <td>
                                    ${item.username}
                                </td>
                                <td>
                                    <button class="btn btn-warning" data-toggle="modal" data-target="#update"
                                            onclick="getByIdUpdate(${item.id})"
                                            >
                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                    </button>
                                </td>

                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>


        </body>
    </html>
</f:view>
