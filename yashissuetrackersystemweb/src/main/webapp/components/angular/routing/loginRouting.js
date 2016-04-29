var myApp=angular.module('issueTrackerSystem.myLogin',['ngRoute','issueController']);
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
                      controller:'IssueController as ic',
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
                      controller:'IssueController as ic',
			           templateUrl:'userWelcome'
                 })
                 .when('/userDashboard',{
               	  
					templateUrl:'userWelcome',
					controller:'IssueController as ic'
                 })
                 .when('/managerDashboard',{
               	  
					templateUrl:'managerWelcome',
					controller:'IssueController as ic'
                 })
                 .otherwise({     
               	  
						  controller:'UserLoginController',
				          templateUrl:'./Login/loginForm'
	               });
							
   });
     