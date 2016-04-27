<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>YITS</title>
	<!-- angular scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
<script src='<spring:url value="/components/angular/controller/issueController.js"></spring:url>'></script>
<script src='<spring:url value="/components/angular/service/initializeIssueService.js"></spring:url>'></script>
</head>
<body ng-app="issueTrackerApp">

	<h3>welcome page</h3>
	
	<a href="#/createIssue">Create Issue</a>
	
	<div ng-view=""></div>
	
</body>
</html>