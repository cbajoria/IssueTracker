  var myApp=angular.module('myApp',['ngRoute','myApp.UserController','myApp.UserService']);
  myApp.config(function($routeProvider){     
						 
		 $routeProvider
               .when('/Login',
                  {
                     controller:'UserController',
			          templateUrl:'login'
                   })
                   .when('/Manager',
                  {
                	   resolve :
                		   {
                		     check : function($location,$rootScope)
                		     {
                		    	 console.log($rootScope.flag);
                		    	 if($rootScope.flag == "false")
                		    		 {
                		    		   $rootScope.flag="false";
                		    		   $location.path('/Login'); 
                		    		 }
                		     }
                		   },
                       controller:'UserController',
			           templateUrl:'manager'
                  })
                    .when('/User',
                  {
                    	 resolve :
                		   {
                		     check : function($location,$rootScope)
                		     {
                		    	 if($rootScope.flag == "false")
                		    		 {
                		    		    $rootScope.flag="false";
                		    		    $location.path('/Login'); 
                		    		 }
                		     }
                		   },
                       controller:'UserController',
			           templateUrl:'./userWelcome'
                  })
                  .otherwise(
						  {     
							  controller:'UserController',
					          templateUrl:'./Login/loginForm'
	                                  });
							   
							  
   
   		 
                      });
      