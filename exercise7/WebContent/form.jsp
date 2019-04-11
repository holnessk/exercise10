<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bayani- EXERCISE 7</title>
</head>
<body>
<form method="post" action="HomeController">
<h1>Exercise 7</h1>
First Name: <input type="text" name="fName"> <br>
Last Name: <input type="text" name="lName"> <br>
Email: <input type="text" name="email"><br>
Phone number: <input type="text" name="phone">
<input type="submit" name="button1" value="Go!" />
</form>
<form method="post" action="HomeController">
<h1>Search Part 3</h1>
Please enter First Name: <input type="text" name="firstName"> <br>
Please enter Last Name: <input type="text" name="lastName"> <br>
<input type="hidden" name="query" value="true"/>
<input type="submit" name="button1" value="Search" />
<h1>'<%=request.getAttribute("error")%>'</h1>
</form>

<c:forEach items="${personList}" var="item">

<h1> NAME: ${item.firstName} ${item.lastName}  </h1> <br>
<h3>Number:  ${item.email}  Phone: ${item.phone} </h3><br>
</c:forEach>

</body>
</html>