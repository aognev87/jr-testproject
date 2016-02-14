<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>


</head>
<body>

<center>

  <div style="color: teal; font-size: 30px">Java Rush CRUD | User
   Search Results</div><br>


      <h2>${resultStr}</h2>
        <c:if test="${!empty userList}">
         <table border="1" bgcolor="black" width="600px">
          <tr style="background-color: teal; color: white; text-align: center;"height="40px">
           <td>#</td>
           <td>Name</td>
           <td>Age</td>
           <td>Administrator</td>
           <td>Created Date</td>
           <td>Edit</td>
           <td>Delete</td>

           <!--
           <td>CName</td>
           <td>CAge</td>
           <td>CAdmin</td>
           -->
          </tr>
          <c:forEach items="${userList}" var="user" varStatus="loopCounter">
           <tr style="background-color: white; color: black; text-align: center;"height="30px">

            <td>${loopCounter.count + rowsPerPage * (pageNumber - 1)}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>

            <c:if test="${user.isAdmin == 0}">
                <td>NO</td>
            </c:if>

            <c:if test="${user.isAdmin == 1}">
                <td>YES</td>
            </c:if>

            <td>${user.createdDate}</td>

            <form:form id="gotoPageForm_0" method="post" modelAttribute="page" action="searchListAction">

                <form:input type="hidden" path="userId" value="${user.userId}" />
                <form:input type="hidden" path="name" value="${user.name}" />
                <form:input type="hidden" path="age" value="${user.age}" />
                <form:input type="hidden" path="isAdmin" value="${user.isAdmin}" />
                <form:input type="hidden" path="createdDate" value="${user.createdDate}" />

                <form:input type="hidden" path="checkedName" value="${page.checkedName}" />
                <form:input type="hidden" path="checkedAge" value="${page.checkedAge}" />
                <form:input type="hidden" path="checkedAdmin" value="${page.checkedAdmin}" />
                <form:input type="hidden" path="page" value="${page.page}" />
                <form:input type="hidden" path="rowsPerPage" value="${page.rowsPerPage}" />

                <td><button type="submit" name="update" value="1" />Edit</button></td>
                <td><button type="submit" name="delete" value="1" />Delete</button></td>

                <!--

                <td>${page.checkedName}</td>
                <td>${page.checkedAge}</td>
                <td>${page.checkedAdmin}</td>

                -->

            </form:form>

           </tr>
          </c:forEach>
         </table>
        </c:if>

  <br>

    <form:form id="gotoPageForm_1" method="post" modelAttribute="page" action="searchListAction">
         <form:input type="hidden" path="userId" value="${page.userId}" />
         <form:input type="hidden" path="name" value="${page.name}" />
         <form:input type="hidden" path="age" value="${page.age}" />
         <form:input type="hidden" path="isAdmin" value="${page.isAdmin}" />
         <form:input type="hidden" path="createdDate" value="${page.createdDate}" />

         <form:input type="hidden" path="checkedName" value="${page.checkedName}" />
         <form:input type="hidden" path="checkedAge" value="${page.checkedAge}" />
         <form:input type="hidden" path="checkedAdmin" value="${page.checkedAdmin}" />
         <form:input type="hidden" path="page" value="${page.page}" />
         <form:input type="hidden" path="rowsPerPage" value="${page.rowsPerPage}" />

        <table>
            <tr>
                <td>Page </td>
                <td><form:input type="text" style="text-align:center" size="3" path="pageRequest" value="${pageNumber}"/></td>
                <td>of ${pagesCount}</td>

                <td><input type="submit" value="Go" /></td><br>
            </tr>
        </table>

    </form:form>

    <form:form id="gotoPageForm_2" method="post" modelAttribute="page" action="searchListAction">
         <form:input type="hidden" path="userId" value="${page.userId}" />
         <form:input type="hidden" path="name" value="${page.name}" />
         <form:input type="hidden" path="age" value="${page.age}" />
         <form:input type="hidden" path="isAdmin" value="${page.isAdmin}" />
         <form:input type="hidden" path="createdDate" value="${page.createdDate}" />

         <form:input type="hidden" path="checkedName" value="${page.checkedName}" />
         <form:input type="hidden" path="checkedAge" value="${page.checkedAge}" />
         <form:input type="hidden" path="checkedAdmin" value="${page.checkedAdmin}" />
         <form:input type="hidden" path="page" value="${page.page}" />
         <form:input type="hidden" path="rowsPerPage" value="${page.rowsPerPage}" />


    <table>
        <tr>
          <c:if test="${firstPage > 0}">
            <td><button type="submit" name="pageRequest" value="0" />First page</button></td>
            <td> | </td>
          </c:if>

          <c:if test="${firstPage < 0}">
            <td><button disabled>First page</button></td>
            <td> | </td>
          </c:if>

          <c:if test="${previousPage > 0}">
            <td><button type="submit" name="pageRequest" value="${pageNumber - 1}" />Previous page</button></td>
            <td> | </td>
          </c:if>

          <c:if test="${previousPage < 0}">
            <td><button disabled>Previous page</button></td>
            <td> | </td>
          </c:if>

          <c:if test="${nextPage > 0}">
            <td><button type="submit" name="pageRequest" value="${pageNumber + 1}" />Next page</button></td>
            <td> | </td>
          </c:if>

          <c:if test="${nextPage < 0}">
            <td><button disabled>Next page</button></td>
            <td> | </td>
          </c:if>

          <c:if test="${lastPage > 0}">
            <td><button type="submit" name="pageRequest" value="last" />Last page</button></td>
          </c:if>

          <c:if test="${lastPage < 0}">
            <td><button disabled>Last page</button></td>
          </c:if>

        </tr>
    </table>

    <table>
        <tr>
            <td>Set rows per page:</td>

            <c:if test="${page.rowsPerPage != 5}">
                <td><button type="submit" name="rowsPerPageRequest" value="5" />5</button></td>
            </c:if>

            <c:if test="${page.rowsPerPage == 5}">
                <td><button disabled>5</button></td>
            </c:if>


            <c:if test="${page.rowsPerPage != 10}">
                <td><button type="submit" name="rowsPerPageRequest" value="10" />10</button></td>
            </c:if>

            <c:if test="${page.rowsPerPage == 10}">
                <td><button disabled>10</button></td>
            </c:if>

            <c:if test="${page.rowsPerPage != 50}">
                <td><button type="submit" name="rowsPerPageRequest" value="50" />50</button></td>
            </c:if>

            <c:if test="${page.rowsPerPage == 50}">
                <td><button disabled>50</button></td>
            </c:if>
        </tr>
    </table>


    </form:form>

    <br>
  <a href="start">Start Page</a>

 </center>

</body>
</html>