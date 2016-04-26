issueModule.factory('issueService',['$http',function($http){
	
	  return {
		  
			  addIssueType: function(issueTypeForm) {
		      		
			          return $http.post('./issuetype/addIssueType.htm',issueTypeForm)
			              .then(
			                      function(response){
			                          return response.data;
			                      }, 
			                      function(errResponse){
			                          console.error('Error while fetching users');
			                              return $q.reject(errResponse);
			                      }
			                );
			      	}
	  }
}]);