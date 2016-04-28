angular.module('myApp.UserService', []).factory('UserService',['$http','$q',function($http,$q){
  				return{
  					
  						validateUser:function(user){
  								alert("inside service validate user");
  								return $http.post('http://localhost:8080/yashissuetrackersystemweb/Login/validateUser',user)
  							 	.then(
                                    	 function(response){
                                         	return response.data;
                                    	 }, 
                                    	 function(errResponse){
                                         	console.error('Error while creating user in service');
                                         	return $q.reject(errResponse);
                                     	 }
                             		);
  						},
  						
  						
  						
  					}
   					 
  				
  			}]);
  
  