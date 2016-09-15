<%-- 
    Document   : studies
    Created on : Sep 26, 2015, 3:02:17 PM
    Author     : Arun
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Studies</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js" type="text/javascript"></script>

        
        <script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1030668766989628',
      xfbml      : true,
      version    : 'v2.5'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>
<script type="text/javascript">
$(document).ready(function(){
$('#share_button').click(function(e){
e.preventDefault();
FB.ui(
{
method: 'feed',
name: 'This is the content of the "name" field.',
link: ' http://localhost:8080/NbadProject1/myStudies',
picture: 'http://www.hyperarts.com/external-xfbml/share-image.gif',
caption: 'This is the content of the "caption" field.',
description: 'This is the content of the "description" field, below the caption.',
message: ''
});
});
});
</script>
    
	<%@include file="header2.jsp"%>
	<p>
		<span class="side_head1"><strong>My Studies</strong></span>
	</p>
	<div id="divBody2">
		<form action="editstudy.jsp">
			<a href="newstudy.jsp">Add A New Study</a><br> <a
				href="main.jsp"> &lt;&lt;Back to the Main Page</a><br> <br>
			<br>
			<table class="form">
				<tbody>
					<tr class="studies">
						<td class="head">Study Name</td>
						<td class="head">Requested Participants&nbsp;&nbsp;&nbsp;</td>
						<td class="head">Participations</td>
						<td class="head1">Status</td>
						<td class="head1">Action</td>
                                        <td class="head1">&nbsp;</td>
					</tr>
					<c:forEach var="study" items="${result}"
						varStatus="loop">
						<tr>
							<td><c:out value="${study.name}"/></td>
                                                        <td><c:out value="${study.requestedParticipants}"/></td>
							<td><c:out value="${study.numOfParitipants}"/></td>
							<td>
							<c:choose>
									<c:when test="${study.status == 'stopped'}">
										<button class="stud" type="submit" name="studyCode"
											value="${study.code}" onclick="{form.action='start';}">Start</button>
									</c:when>
									<c:otherwise>
										<button class="stud" type="submit" name="studyCode"
											value="${study.code}" onclick="{form.action='stop';}">Stop</button>
									</c:otherwise>
								</c:choose>
							</td>
							<td><button class="stud" type="submit" name="studyCode"
									value="${study.code}" onclick="{form.action='edit';}">Edit</button></td>
                                                                                <td><img src = "images\share.jpg" id = "share_button"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<%@include file="footer.jsp"%>
           

</body>
</html>
