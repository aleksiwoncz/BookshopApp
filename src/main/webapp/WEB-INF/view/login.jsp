<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>Bootstrap Sign in Form with Icons</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="/resources/bootstrap/css/login.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="signup-form">
    <c:if test="${(param.error != null) && (not empty SPRING_SECURITY_LAST_EXCEPTION)}">
       <p><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></p>
    </c:if><form:form method="post">
		<h2>Sign In</h2>
		<p>Please fill in this form to sign in!</p>
		<hr>
        <div class="form-group">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<span class="fa fa-user"></span>
					</span>
				</div>
				<input type="text" class="form-control" id="username" name="username" placeholder="Username" required="required">
			</div>
        </div>
		<div class="form-group">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<i class="fa fa-lock"></i>
					</span>
				</div>
				<input type="password" class="form-control" id="password" name="password" placeholder="Password" required="required">
			</div>
        </div>
		<div class="form-group">
             <div class="col-md-12 text-center">
                  <button type="submit" class="btn btn-primary btn-xl">Sign In</button>
             </div>
        </div>
        <div class="text-center">Dont have an accout? <a href="/register">Sign up here</a></div>
    </form:form>
</div>
</body>
</html>