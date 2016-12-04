<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<body>
<h1>User</h1>
successfully created<br/>
<c:out value="${user.userName}" /><br/>
<c:out value="${user.email}" />
</body>
</html>