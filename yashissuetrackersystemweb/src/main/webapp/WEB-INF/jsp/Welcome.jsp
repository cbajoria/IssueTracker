<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script src='<c:url value="components/angular/controller/UserController.js"></c:url>'></script>
	<script src='<c:url value="components/angular/service/UserService.js"></c:url>'></script>
	<script src='<c:url value="components/angular/routing/Routing.js"></c:url>'></script>
	<script src='<c:url value="components/angular/angular-route.min.js"></c:url>'></script>
	
</head>
<body  ng-app="myApp">

			<div>
				<div ng-view=""></div>
			</div>

</body>
</html>