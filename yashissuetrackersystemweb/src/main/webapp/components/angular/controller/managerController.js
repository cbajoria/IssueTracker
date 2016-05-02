angular.module('issueTrackingSystem.managerModule').controller('managerController',['$scope','$http','managerService',function($scope,$http,managerService){

		/*issueService returns list to populate drop-down*/
	managerService.initializeSelect()
        .then(
                 function(d) {
                	 
                	 /*retrieve and assign value from list*/
                	 angular.forEach(d,function(value,key){
            			 switch(key){
            			 	case 0:
            					 $scope.priorities=value;
            					 break;
            			 	case 1:
            			 		$scope.assigneeList=value;
            			 		break;
            			 	case 2:
            			 		$scope.issueTypeList=value;
            			 		break;
            			 	case 3:
            			 		$scope.projects=value;
            			 		break;
            			 }
            		 });
                	 
                 },
                  function(errResponse){
                      console.error('Error while fetching');
                  }
             );
		
		this.createIssue={};
		this.add=function(){
			
			// call service to persist in db
			managerService.submitCreateIssue(this.createIssue);
	        /*.then(
	                 function(d) {
	                	 
	                 },
	                  function(errResponse){
	                      console.error('Error while fetching');
	                  }
	             );*/
			this.createIssue={};
		};
	}]);