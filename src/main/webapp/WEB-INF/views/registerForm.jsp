<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
span.error {
color: red;
}
div.errors {
background-color: #ffcccc;
border: 2px solid red;
}
<html>
<head>
  <title>Spittr</title>
  <link rel="stylesheet" type="text/css"
        href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Register</h1>
<%--<form method="POST">--%>
  <%--First Name: <input type="text" name="firstName" /><br/>--%>
  <%--Last Name: <input type="text" name="lastName" /><br/>--%>
  <%--Username: <input type="text" name="username" /><br/>--%>
  <%--Password: <input type="password" name="password" /><br/>--%>
  <%--<input type="submit" value="Register" />--%>
<%--</form>--%>
<sf:form method="POST" commandName="spitter">
  <%--Or use this to show all errors in one place--%>
  <%--<sf:errors path="*" element="div" cssClass="errors" />--%>
  First Name: <sf:input path="firstName" />
  <sf:errors path="firstName" cssClass="error" /><br/>
  Last Name: <sf:input path="lastName" />
  <sf:errors path="lastName" cssClass="error" /><br/>
  Email: <sf:input path="email" type="email"/>
  <sf:errors path="email" cssClass="error" /><br/>
  Username: <sf:input path="username" />
  <sf:errors path="username" cssClass="error" /><br/>
  Password: <sf:password path="password" />
  <sf:errors path="password" cssClass="error" /><br/>
  <input type="submit" value="Register" />
</sf:form>
</body>
</html>