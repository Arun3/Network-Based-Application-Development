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
			<img class="edit" alt="Image Preview" src="${imageurl}"/>
			</div>
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>
