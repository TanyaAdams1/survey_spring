<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
    <title>Survey result</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="/resources/icon.png"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand navbar-dark sticky-top flex-column flex-md-row bd-navbar"
     style="background-color:#8c0000">
    <a class="navbar-brand" href="http://www.pku.edu.cn" target="_blank">
        <img src="http://pku.edu.cn/img/pkulogo_white.png" alt="PKU"/>
    </a>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="http://net.pku.edu.cn/~zt/wst/" target="_blank">Course Home Page<span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://162.105.146.180/Phorum/index.php" target="_blank">Class Forum</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://162.105.146.180/wst/homework/2017/homework.html" target="_blank">Class
                    Homework Page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/" target="_self">Home Page</a>
            </li>
            <s:if test="#session.type==\"Admin\"">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" href=""
                       aria-haspopup="true" aria-expanded="false">
                        Manager tools
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/manager/html">Manager App</a>
                        <a class="dropdown-item" href="/manager/status">Server Status</a>
                        <a class="dropdown-item" href="/host-manager/html">Host Manager</a>
                        <a class="dropdown-item" href="/document">Documentation</a>
                    </div>
                </li>
            </s:if>
        </ul>
    </div>
    <ul class="text-light navbar-nav">
        <li class="nav-link mt-3 mr-3">
            <p>
                Welcome,<%=session.getAttribute("name")%>
        </li>

    </ul>

    <a class="btn btn-outline-light text-light"
       href="http://162.105.146.180:8047/account/logout.php?redirect=/">Logout</a>
</nav>
<div class="alert alert-info text-center mb-5 mt-2">
    The result of the survey is displayed below.
</div>
<div class="container m-5">
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Contact</th>
                </tr>
                <s:iterator value="people">
                    <tr>
                        <td>
                            <s:property value="name"/>
                        </td>
                        <td>
                            <s:property value="age"/>
                        </td>
                        <td>
                            <s:if test="gender == 0">
                                Male
                            </s:if>
                            <s:elseif test="gender ==1 ">
                                Female
                            </s:elseif>
                            <s:else>
                                Otherwise
                            </s:else>
                        </td>
                        <td>
                            <s:property value="email"/>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </div>
    </div>
    <div class="row m-3">

        <div class="col">
            <s:form action="delete">
                <s:checkboxlist list="people" listKey="id" listValue="name" name="deleteList"
                                label="Plese select from below the people you wish to remove" labelposition="top"/>
                <s:submit cssClass="btn btn-success"/>
            </s:form>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
</body>
</html>