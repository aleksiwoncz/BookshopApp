<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
        <link href="/resources/bootstrap/css/bookslist.css" rel="stylesheet" />
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>

<div class="container py-5">
    <div class="row text-center text-white mb-5">
        <div class="col-lg-7 mx-auto">
            <h1 class="display-6">Edit Author</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 mx-auto">
            <!-- List group-->
            <ul class="list-group shadow">
                <!-- list group item-->
                <li class="list-group-item">
                    <!-- Custom content-->
                    <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                        <div class="media-body order-2 order-lg-1">
                            <form:form action="adminadd" modelAttribute="author" method="POST" class="form-horizontal">
                            <!-- Text input-->
                            <div>
                                <!-- Select Basic -->
                                <div class="form-group">
                                   <label class="col-md-4 control-label" for="firstName">FIRST NAME</label>
                                   <div class="col-md-4">
                                      <form:input path="firstName" id="firstName" class="form-control"/>
                                   </div>
                                </div>
                                <!-- Textarea -->
                                <div class="form-group">
                                   <label class="col-md-4 control-label" for="lastName">LAST NAME</label>
                                   <div class="col-md-4">
                                      <td><form:input path="lastName" id="lastName" class="form-control"/></td>
                                   </div>
                                </div>
                                <!-- Button -->
                                <div class="col-md-12 text-center">
                                    <td><form:hidden path="id"/></td>
                                    <button type="submit" class="btn btn-warning">Save</button>
                                </div>
                            </form:form>
                        </div>
                    </div> <!-- End -->
                </li> <!-- End -->
            </ul> <!-- End -->
        </div>
    </div>
</div>
</body>
</html>