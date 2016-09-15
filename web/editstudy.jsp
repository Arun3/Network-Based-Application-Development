<%-- 
    Document   : home
    Created on : Sep 20, 2015, 2:07:42 PM
    Author     : Arun
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Study</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
	<%@include file="header2.jsp"%>
	<p>
		<span class="side_head1"><strong>Editing a study</strong></span>
	</p>
	<form action="update" method="post" enctype="multipart/form-data">
		<div class="sty">
		<input type="hidden" name = "studyCode" value="<c:out value="${study.code}"></c:out>">
			<label class="labelclass">Study Name *</label> <input class="in1"
				type="text" name="studyName" required="required" value="<c:out value="${study.name}"></c:out>"> <br> 
			<label class="labelclass">Question
				Text *</label> <input class="in1" type="text"  name="questionText" value="<c:out value="${study.question}"></c:out>"> <br>
			<label class="labelclass">Image *</label>
			<img class="edit" alt="Image Preview" src="<c:out value="${study.imageURL}"></c:out>"/>
			<input type="file" name="imageFile" id="imageFile">
			<br> <label class="labelclass"># Participants*</label> <input
				class="in1" type="text"  name="participants" value="<c:out value="${study.requestedParticipants}"></c:out>"> <br> <label class="labelclass">Description
				*</label>
			<textarea class="in2"  name="description" ><c:out value="${study.description}"></c:out></textarea>
			<br> <input class="sb" value="Update" type="submit">
		</div>
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>
