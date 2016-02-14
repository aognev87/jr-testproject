<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>

 <center>

  <div style="color: teal; font-size: 30px">Java Rush CRUD | Registration Form</div><br>


  <form:form id="registerForm" modelAttribute="user" method="post" action="register">
	<table bgcolor="black" border="1">
		<tr style="background-color: teal; color: white; text-align: center;" height="40px" >
			<td align="center">Name:</td>
			<td align="center">Age:</td>
			<td align="center">Administrator:</td>

		<tr>

		<tr style="background-color: white; color: black; "height="30px">
			<td><form:input style="text-align:center" path="name" value="User name" required="required"/></td>
			<td><form:input pattern="^[0-9]+$" style="text-align:center" size="2" path="age" required="required"/></td>
			<td align="center">
				<select name="isAdmin">
				  <option value="0">NO</option>
				  <option value="1">YES</option>
				</select>
			</td>
		</tr>
	</table><br>

	<input type="submit" value="Register" />

  </form:form>

    <br>
    <a href="start">Start Page</a>
 </center>


</body>
</html>