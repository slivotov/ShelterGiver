<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<body>
<h1>create user</h1>
<sf:form method="POST" commandName="createUser">
    Email: <sf:input path="email" type="email"/>
    <sf:errors path="email"  /><br/><br/>
    Username: <sf:input path="userName" />
    <sf:errors path="userName" cssClass="error" /><br/><br/>
    Password: <sf:password path="password" />
    <sf:errors path="password" cssClass="error" /><br/><br/>
    <input type="submit" value="createUser" />
</sf:form>
</body>
</html>