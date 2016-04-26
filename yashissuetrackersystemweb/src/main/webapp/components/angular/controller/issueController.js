var issueModule = angular.module('issueTrackerApp',['ngRoute']);
	issueModule.config(function($routeProvider){
		$routeProvider
			.when('/addIssueType',{
				templateUrl:'issuetype/showIssueTypeForm.htm',
				controller:'issueController as ic'
			})
	});
	
	issueModule.controller('issueController',['$scope','$http','issueService',function($scope,$http,issueService){
		
		/*issueService returns list to populate drop-down*/
		this.issueTypeForm={};
		this.add=function(){
			// call service to persist in db
			issueService.addIssueType(this.issueTypeForm)
			.then(
	                 function(d) {
	                	 alert(d);
	                 },
	                  function(errResponse){
	                      console.error('Error while fetching');
	                  }
	             );
			this.issueTypeForm={};
		};
	}]);