<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>upcoming</title>
    <link rel="stylesheet" href="styles.css">
    <script src="https://kit.fontawesome.com/6475909a3d.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="upcoming">
        <div class="heading">Upcoming Interviews</div>
        <div id="title">
            <span id="name">Id</span>
            <span id="date">Name</span>
            <span id="st">Start time</span>
            <span id="et">End time</span>
        </div>
        <c:forEach var="interview" items="${interviews}">
					<option value="${interview.getInterviewId()}">${interview.getInterviewId()}
						${interview.getInterviewName()}
						${interview.getStartTime()}
						${interview.getEndTime()}</option>
		</c:forEach>
        <form method="get" action="/createInterview">
		    <button type="submit">Create Interview</button>
		</form>
    </div>

    
</body>
</html>

