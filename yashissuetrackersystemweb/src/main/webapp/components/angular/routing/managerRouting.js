var managerModule = angular.module('issueTrackingSystem.managerModule',['ngRoute']);
managerModule.config(function($routeProvider){
		$routeProvider
			.when('/createIssue',{
				templateUrl:'createManagerIssueView',
				controller:'managerController as mc'
			})
	});