angular.module('issueTrackerSystem.myLogin').controller('UserLoginController',['$scope','$location','UserLoginService',function($scope,$location,UserLoginService){
	
		$scope.user={'username':"",'password':""}
		var users= new Object();
		$scope.submit=function()
		{
			alert("inside submit");
			$scope.user.username=$scope.username;
			$scope.user.password=$scope.password;
			$scope.validateUser($scope.user);
		
		}
	
		$scope.validateUser=function(user){
			
			alert("inside validate user");
			 UserLoginService.validateUser(user)
				 .then(
						 function(d) 
						 {
							 users = d;
							 alert("Inside validate"+ users);
							 if(users.userJobTitle == "Trainee Programmer")
							 {
								 $location.path('/userDashboard');
							 }
							 else
							 {
								 $location.path('/managerDashboard');
							 }
						 },
						 function(errResponse)
						 {
							 console.error('Error while creating user in controller');
						 }
             		);
			
		}
	
		
	
	
	
	
	
}]);