<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
  <title>Spring test</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Spring test project</h1>
<a href="<c:url value="/spittles" />">Spittles</a>  |
<a href="<c:url value="/spitter/register" />">Register</a><br/><br/>
<a href="<c:url value="/spitter/createUser" />">createUser</a>
</body>
</html>