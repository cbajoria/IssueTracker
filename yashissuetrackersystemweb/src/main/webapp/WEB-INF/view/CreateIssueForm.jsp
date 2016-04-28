<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<style>
		.registerationForm{
			height:400px;
			width:250px;
			margin:0 auto;
			margin-top:200px;
		}
		.registerationForm div{
			background-color: #fcfafd;
			align:center;
		}
		.login-form{
			padding:10px;
			border-radius:10px;
		}
		.error{
			color: red;
			font-style: italic;
			font-size: 12px;
		}
	</style>

<form class="registerationForm" ng-submit="ic.add()">
	<div class="login-form">
		<div class="form-group">
			<spring:message code="issue.project"/>
			<select ng-model="ic.createIssue.projectForm.projectId" class="form-control">
				<option ng-repeat="project in projects" value="{{project.projectId}}" >{{project.projectName}}</option>
			</select>
		</div>
		<div class="form-group">
			<spring:message code="issue.type"/>
			<select ng-model="ic.createIssue.issueTypeForm.issueId" class="form-control">
				<option ng-repeat="issueType in issueTypeList" value="{{issueType.issueId}}" >{{issueType.issueType}}</option>
			</select>
		</div>
		<div class="form-group">
			<spring:message code="issue.priority"/>
			<select ng-model="ic.createIssue.issuePriorityForm.issuePriorityId" class="form-control" >
				<option ng-repeat="priority in priorities" value="{{priority.issuePriorityId}}">{{priority.issuePriorityType}}</option>
			</select>
		</div>
		<div class="form-group">
			<spring:message code="issue.summary"/>
			<input type="text" ng-model="ic.createIssue.issueSummary" class="form-control" />
		</div>
		<%-- <div class="form-group">
			<spring:message code="issue.creationDate"/>
			<input type="date" ng-model="ic.createIssue.issueCreationDate" class="form-control" disabled/>
		</div>
		<div class="form-group">
			<spring:message code="issue.dueDate"/>
			<input type="date" ng-model="ic.createIssue.issueDueDate" class="form-control" />
		</div> --%>
		<div class="form-group">
			<spring:message code="issue.component"/>
			<input type="text" ng-model="ic.createIssue.issueComponent" class="form-control" />
		</div>
		<div class="form-group">
			<spring:message code="issue.affectedVersion"/>
			<input type="text" ng-model="ic.createIssue.issueAffectedVersion" class="form-control" />
		</div>
		<div class="form-group">
			<spring:message code="issue.assignee"/>
			<select ng-model="ic.createIssue.userForm.userId" class="form-control" >
				<option value="{{assignee.userId}}" ng-repeat="assignee in assigneeList" value="{{assignee.userId}}">{{assignee.userName}}</option>
			</select>
		</div>
		<div class="form-group">
			<spring:message code="issue.environment"/>
			<input type="text" ng-model="ic.createIssue.issueEnvironment" class="form-control" />
		</div>
		<div class="form-group">
			<spring:message code="issue.Description"/>
			<textarea rows="4" cols="50" ng-model="ic.createIssue.issueDescription" class="form-control" ></textarea>
		</div>
		<div class="form-group">
			<spring:message code="issue.originalEstimate"/>
			<input type="text" ng-model="ic.createIssue.issueOriginalEstimate" class="form-control" />
		</div>
	<%-- <div class="form-group">
			<spring:message code="issue.remainingEstimate"/>
			<input type="text" ng-model="ic.createIssue.issueRemainingEstimate" class="form-control" />
		</div>
		<div class="form-group">
			<spring:message code="issue.assignedStatus"/>
			<select ng-model="ic.createIssue.issueAssignedStatusForm.issueAssignmentStatusId" class="form-control" >
				<option ng-repeat="assignedStatus in assignedStatusList" value="assignedStatus.issueAssignmentStatusId">{{assignedStatus.issueAssignmentStatus}}</option>
			</select>
		</div>
		<div class="form-group">
			<spring:message code="issue.status"/>
			<select ng-model="ic.createIssue.issueStatusForm.issueStatusId" class="form-control" >
				<option ng-repeat="issueStatus in issueStatusList" value="issueStatus.issueStatusId">{{issueStatus.issueStatusType}}</option>
			</select>
		</div> --%>
		<div class="form-group">
			<input type="submit" value="<spring:message code="issue.save"/>"/>
		</div>
	</div>
</form>
