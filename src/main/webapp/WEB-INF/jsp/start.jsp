<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Start page</title>
    </head>

    <body>

        <center>
            <div style="color: teal; font-size: 30px">Java Rush CRUD | Start Page</div><br>
            <table bgcolor="black" border="1">
                <tr style="background-color: teal; color: white; text-align: center;" height="40px" >
                    <td colspan="3" align="center">CRUD Options</td>
                </tr>

                <tr style="background-color: white; color: black; "height="30px">
                    <form:form id="startForm" method="post" action="startAction">

                        <td><input type="submit" name="action" value="Add a new User" /></td>
                        <td><input type="submit" name="action" value="Search Form" /></td>
                        <td><input type="submit" name="action" value="Show all Users" /></td>

                    </form:form>
                </tr>
            </table>
        </center>


    </body>
</html>