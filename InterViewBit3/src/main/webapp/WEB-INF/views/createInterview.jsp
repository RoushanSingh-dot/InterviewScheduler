<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Add Interview</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet" />
	<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>
</head>

<body>
	<h3>Interview Scheduler</h3>
	<div class="content-container">
		<div class="form-container">
			<form action="" method="post">
				<div class="form-item">
					<label for="interviewId">Interview Id: </label>
					<input class="text-input" type="text" id="interviewId" name="interviewId" maxlength="10"
						required="required"><br>
				</div>
				<div class="form-item">
					<label for="interviewName">Interview Name: </label>
					<input class="text-input" type="text" id="interviewName" name="interviewName" maxlength="50"
						required="required"><br>
				</div>
				<div id="startAndEndTime">
					<div class="form-item">
						<label for="startTime">Start Time: </label>
						<input class="text-input" type="datetime-local" id="startTime" name="startTime"
							required="required"><br>
					</div>
					<div class="form-item">
						<label for="endTime">End Time: </label>
						<input class="text-input" type="datetime-local" id="endTime" name="endTime"
							required="required"><br>
					</div>
				</div>
				<div class="form-item">
					<label for="participants">Participants: </label>
					<select data-placeholder="Choose Participants" multiple="multiple" class="js-example-basic-multiple"
						id="participants" name="participants" required="required">
						<option value="">Choose Participants</option>
						<c:forEach var="participant" items="${participants}">
							<option value="${participant.getEmailId()}">${participant.getParticipantName()}
								(${participant.getEmailId()})</option>
						</c:forEach>
					</select>
				</div>
				<script type="text/javascript">
					$(document).ready(function () {
						$('.js-example-basic-multiple').select2();
					});
				</script>
				</form>
				        <form method="get" action="/createInterview">
						    <button type="submit">Create Interview</button>
						</form>
			
					</div>
					<p class="alert-text" style="color: red;">${error}</p>
				</div>
				<script type="text/javascript">
					$(document).ready(function () {
						$('.js-example-basic-multiple').select2();
					});
					</script>
		
</body>

</html>