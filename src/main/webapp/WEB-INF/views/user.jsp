<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>user Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a user
</h1>



<c:url var="addAction" value="/user/add" ></c:url>

<form:form action="${addAction}" commandName="user">
    <table>
        <c:if test="${!empty user.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="age">
                    <spring:message text="Age"/>
                </form:label>
            </td>
            <td>
                <form:input path="age" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="isadmin">
                    <spring:message text="Admin"/>
                </form:label>
            </td>
            <td>
                <form:checkbox path="isadmin"/>
            </td>
        </tr>


        <tr>
            <td colspan="2">
                <c:if test="${!empty user.name}">
                    <input type="submit"
                           value="<spring:message text="Edit"/>" />
                </c:if>
                <c:if test="${empty user.name}">
                    <input type="submit"
                           value="<spring:message text="Add"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<h1>
    Set filter
</h1>



<form:form action="/user/flt" commandName="filter">
    <table>
            <tr>
                <td>
                    <form:label path="nameflt">
                        <spring:message text="Filter "/>
                    </form:label>
                </td>
                <td>
                    <form:input path="nameflt" size="8" />
                    <input type="submit"
                           value="<spring:message text="Apply filter"/>" />
                </td>
            </tr>
    </table>
</form:form>


<br>
<h3>users List</h3>
<c:if test="${!empty listusers}">
    <table class="tg">
        <tr>
            <th width="80">user ID</th>
            <th width="120">Name</th>
            <th width="120">Age</th>
            <th width="120">Admin </th>
            <th width="120">Creation date</th>

            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listusers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td> ${user.isadmin}</td>
                <td> ${user.createdDate}</td>

                <td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <c:forEach items="${listpage}" var="page">
        <c:if test="${page == curpage} ">

            <td>!!<a href="<c:url value='/users/${page}'/>" >${page}</a> !! | </td>
        </c:if>


            <td><a href="<c:url value='/users/${page}'/>" >${page}</a> | </td>

    </c:forEach>
    Current page ${curpage}
</c:if>
</body>
</html>