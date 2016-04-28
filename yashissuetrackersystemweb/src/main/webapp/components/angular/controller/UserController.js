angular.module('myApp.UserController', []).controller('UserController',['$scope','$location','UserService',function($scope,$location,UserService){
	
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
			 UserService.validateUser(user)
				 .then(
						 function(d) 
						 {
							 users = d;
							 alert("Inside validate"+ users);
							 if(users.userJobTitle == "Trainee Programmer")
							 {
								 $location.path('/User');
							 }
							 else
							 {
								 $location.path('/Manager');
							 }
						 },
						 function(errResponse)
						 {
							 console.error('Error while creating user in controller');
						 }
             		);
			
		}
	
		
	
	
	
	
	
}]);