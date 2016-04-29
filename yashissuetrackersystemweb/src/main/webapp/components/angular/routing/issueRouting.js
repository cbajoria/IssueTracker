var issueModule = angular.module('issueTrackerApp',['ngRoute']);
	issueModule.config(function($routeProvider){
		$routeProvider
			.when('/createIssue',{
				templateUrl:'createIssueView',
				controller:'issueController as ic'
			})
			.when('/userDashboard',{
				templateUrl:'userWelcome',
				controller:'issueController as ic'
			})
			.when('/managerDashboard',{
				templateUrl:'managerWelcome',
				controller:'issueController as ic'
			})
	});