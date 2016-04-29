var myApp=angular.module('issueTrackerSystem.myLogin',['ngRoute']);
 myApp.config(function($routeProvider){     
						 
		 $routeProvider
              .when('/Login',
                 {
                    controller:'UserLoginController',
			          templateUrl:'./Login/loginForm'
                  })
                .when('/managerDashboard',
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
                      controller:'issueController as ic',
			           templateUrl:'managerWelcome'
                 })
                   .when('/userDashboard',
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
                      controller:'issueController as ic',
			           templateUrl:'userWelcome'
                 })
                 .otherwise({     
               	  
						  controller:'UserLoginController',
				          templateUrl:'./Login/loginForm'
	               });
							
   });
     