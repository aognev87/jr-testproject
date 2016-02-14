<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User</title>

<script type="text/javascript">

function validate_form ( ){
	valid = true;

    if ( document.search_form.name.value == "" && document.search_form.checkedName.checked == true){
        alert ( "Fill 'name' or uncheck search by name." );
        valid = false;
    }

    if ( document.search_form.age.value == "" && document.search_form.checkedAge.checked == true){
        alert ( "Fill 'age' or uncheck search by age." );
        valid = false;
    }

    if ( document.search_form.age.value == "" && document.search_form.checkedAge.checked == false){
        document.search_form.age.value = "0";
    }

    return valid;
}

</script>


</head>
<body>

 <center>

  <div style="color: teal; font-size: 30px">Java Rush CRUD | Search Form</div><br>

  <form:form name="search_form" id="searchForm" modelAttribute="page" method="post" action="searchListAction" onSubmit="return validate_form ( );">
   <table bgcolor="black" border="1">
       <tr style="background-color: teal; color: white; text-align: center;" height="40px" >
            <td align="center">Search by:</td>
            <td align="center">Value:</td>
            <td align="center" width="120px">Enable / disable search option</td>
        </tr>

        <tr style="background-color: white; color: black; "height="30px">
            <td align="center">name</td>
            <td align="center"><form:input style="text-align:center" path="name" value="User name"/></td>
            <td align="center">
                <input type="checkbox" name="checkedName" value="1">
            </td>
        </tr>

        <tr style="background-color: white; color: black; "height="30px">
            <td align="center">age</td>
            <td align="center"><form:input pattern="^[0-9]+$" style="text-align:center" size="2" path="age" value="0"/></td>
            <td align="center">
                <input type="checkbox" name="checkedAge" value="1">
            </td>
        </tr>

        <tr style="background-color: white; color: black; "height="30px">
            <td align="center">administrator</td>
            <td align="center">
                <select name="isAdmin">
                  <option selected value="0">NO</option>
                  <option value="1">YES</option>
                </select>
            </td>
            <td align="center">
                <input type="checkbox" name="checkedAdmin" value="1">
            </td>
        </tr>
    </table><br>

    <center>
        <input type="submit" value="Search" />
    </center>

  </form:form>

    <br>
  <a href="start">Start Page</a>
 </center>


</body>
</html>