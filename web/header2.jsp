<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<div id="headerLevel2">
		<h1 id="headerH1"><a href="userController?action=home">Researchers Exchange Participations</a></h1>
                <a class="admin" href="userController?action=logout">Logout</a>
                <a class="admin">Hello,<c:out value="${theUser.name}"/> !</a>
		<a class="admin" href="userController?action=how">How It Works</a>
		<a class="admin" href="userController?action=about">About Us</a>
                
	</div>
</div>
                
