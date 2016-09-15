<%-- 
    Document   : home
    Created on : Sep 20, 2015, 2:07:42 PM
    Author     : Arun
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a New Study</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
	<%@include file="header2.jsp"%>
	<p>
		<span class="side_head1"><strong>Adding a study</strong></span>
	</p>
	<form action="add" method="post" enctype="multipart/form-data">
		<div class="sty">
			<label class="labelclass">Study Name *&nbsp;&nbsp;
			</label> <input class="in1" type="text" name="studyName" required="required"> <br> 
			<label class="labelclass">Question Text *&nbsp;&nbsp;</label> <input class="in1" type="text" name="questionText" required="required"> <br>
			<label class="labelclass">Image *&nbsp;&nbsp;</label>
			<input type="file" name="imageFile" id="imageFile" required="required">
			<br> <label class="labelclass"># Participants
				*&nbsp;&nbsp;</label> <input class="in1" type="number" name="participants" required="required"> <br> <label
				class="labelclass">Description *&nbsp;&nbsp;</label>
			<textarea class="in2" name="description" required="required"></textarea>
			<br> <input class="sb" value="Submit" type="submit">
		</div>
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>
