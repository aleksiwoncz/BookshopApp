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
            <h1 class="display-6">Add Book</h1>
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
                            <form:form action="adminadd" modelAttribute="book" method="POST" class="form-horizontal">
                            <!-- Text input-->
                            <div>
                                <!-- Select Basic -->
                                <div class="form-group">
                                   <label class="col-md-4 control-label" for="title">TITLE</label>
                                   <div class="col-md-4">
                                      <form:input path="title" id="title" class="form-control"/>
                                   </div>
                                </div>
                                <!-- Textarea -->
                                <div class="form-group">
                                   <label class="col-md-4 control-label" for="publisher">PUBLISHER</label>
                                   <div class="col-md-4">
                                      <td><form:input path="publisher" id="publisher" class="form-control"/></td>
                                   </div>
                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                   <label class="col-md-4 control-label" for="category">CATEGORY</label>
                                   <div class="col-md-4">
                                      <form:select path="category" id="categories" class="form-control">
                                         <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                                      </form:select>
                                   </div>
                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                   <label class="col-md-4 control-label" for="authors">AUTHORS</label>
                                   <div class="col-md-4">
                                      <form:select path="authors" id="authors" class="form-control">
                                         <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
                                      </form:select>
                                   </div>
                                </div>

                               <!-- Text input-->
                                <div class="form-group">
                                   <label class="col-md-4 control-label" for="price">PRICE</label>
                                   <div class="col-md-4">
                                   <td><form:input path="price" id="price" class="form-control"/></td>
                                   </div>
                                </div>


                                <!-- Button -->
                                <div class="col-md-12 text-center">
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