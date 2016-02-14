<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User Details</title>
</head>
<body>

<center>

  <div style="color: teal; font-size: 30px">Java Rush CRUD |
   Edit User Details</div><br>

  <form:form id="updateForm" modelAttribute="page" method="post" action="update">
    <table bgcolor="black" border="1">

        <tr style="background-color: teal; color: white; text-align: center;" height="40px" >
            <td align="center">Name:</td>
            <td align="center">Age:</td>
            <td align="center">Administrator:</td>
        <tr>

        <tr style="background-color: white; color: black;" height="30px">
            <td><form:input path="name" style="text-align:center" value="${page.name}" required="required"/></td>
            <td><form:input path="age" pattern="^[0-9]+$" style="text-align:center" size="2" value="${page.age}" required="required"/></td>

            <c:if test="${page.isAdmin == 0}">
                <td align="center">
                    <select name="isAdmin">
                        <option selected value="0">NO</option>
                        <option value="1">YES</option>
                    </select>
                </td>
            </c:if>

            <c:if test="${page.isAdmin == 1}">
                <td align="center">
                    <select name="isAdmin">
                        <option value="0">NO</option>
                        <option selected value="1">YES</option>
                    </select>
                </td>
            </c:if>
        </tr>

    </table><br>

       <form:input type="hidden" path="userId" value="${page.userId}" />
       <form:input type="hidden" path="createdDate" value="${page.createdDate}" />

       <form:input type="hidden" path="checkedName" value="${page.checkedName}" />
       <form:input type="hidden" path="checkedAge" value="${page.checkedAge}" />
       <form:input type="hidden" path="checkedAdmin" value="${page.checkedAdmin}" />
       <form:input type="hidden" path="page" value="${page.page}" />
       <form:input type="hidden" path="rowsPerPage" value="${page.rowsPerPage}" />
       <form:input type="hidden" path="update" value="-1" />
       <input type="submit" value="Update" />

  </form:form><br>

  <a href="start">Start Page</a>

 </center>

</body>
</html>