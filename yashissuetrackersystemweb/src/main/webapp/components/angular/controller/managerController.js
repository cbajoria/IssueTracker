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

angular.module('issueTrackerSystem.managerModule', []).controller(
		'IssueSearchController',
		[ '$scope', '$location', 'IssueSearchService',
				function($scope, $location, IssueSearchService) {

					$scope.getIssues = function() {
						var searchText = $scope.searchText;
						if (searchText == undefined) {
							alert("Please Enter Text!")
						}
						else{
							IssueSearchService.searchIssue(searchText)
							.then(
									function(data){
										$scope.issues=data;
										
									},
									 function(errResponse)
									 {
										 console.error('Error while showing default search issues');
									 }
							)
								
							
						}
					}
					
					$scope.change=function(){
						$('#datatable').remove();
					}
					
					$scope.defaultSearch=function(){
						
						IssueSearchService.showIssues()
						.then(
								function(data){
									$scope.issues=data;
								},
								 function(errResponse)
								 {
									 console.error('Error while searching issues');
								 }
								
						)
						
					}
				} ]);
				