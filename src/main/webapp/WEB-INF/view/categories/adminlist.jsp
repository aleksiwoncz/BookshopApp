<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List books</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/resources/bootstrap/css/bookslist.css" rel="stylesheet" />
</head>
<body>
<div class="container py-5">
    <div class="row text-center text-white mb-5">
        <div class="col-lg-7 mx-auto">
            <h1 class="display-6">Categories List</h1>
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
                              <a class="btn btn-secondary" href="/categories/adminadd" role="button">ADD NEW CATEGORY</a>
                        </div>
                    </div> <!-- End -->
                </li> <!-- End -->
                <c:forEach var="category" items="${categories}">
                    <c:url var="edit" value="/categories/adminedit">
                        <c:param name="categoryId" value="${category.id}"/>
                    </c:url>
                    <c:url var="delete" value="/categories/admindelete">
                        <c:param name="categoryId" value="${category.id}"/>
                    </c:url>
                    <li class="list-group-item">
                        <!-- Custom content-->
                        <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                            <div class="media-body order-2 order-lg-1">
                                <h5 class="mt-0 font-weight-bold mb-2">${category.name}</h5>
                                <div class="d-flex align-items-center justify-content-between mt-1">
                                    <h6 class="font-weight-bold my-2"> </h6>
                                    <ul class="list-inline small">
                                        <li class="list-inline-item m-0"><i class="fa fa-star "></i></li>
                                        <li class="list-inline-item m-0"><i class="fa fa-star "></i></li>
                                        <li class="list-inline-item m-0"><i class="fa fa-star "></i></li>
                                        <li class="list-inline-item m-0"><i class="fa fa-star "></i></li>
                                        <li class="list-inline-item m-0"><i class="fa fa-star-o text-gray"></i></li>
                                    </ul>
                                </div>
                                  <a class="btn btn-warning" href="${edit}" role="button">Edit</a>
                                  <a class="btn btn-warning" href="${delete}" role="button">Delete</a>
                            </div>
                        </div> <!-- End -->
                    </li> <!-- End -->
                </c:forEach>
            </ul> <!-- End -->
        </div>
    </div>
</div>
</body>
</html>