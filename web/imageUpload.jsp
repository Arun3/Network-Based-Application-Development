<%-- 
    Document   : imageUpload
    Created on : Nov 3, 2015, 2:34:19 PM
    Author     : Arun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" method="post" enctype="multipart/form-data" action="imageServlet">
 
<p>
<input type="file" name="ImageFile" id="ImageFile" />
</p>
<p>
<input type="submit" name="submit" value="submit" />
    </body>
</html>
