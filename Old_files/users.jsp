<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: pavelsmirnov
  Date: 17.02.2021
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
<style>
    table{
        border-collapse: collapse;
    }
    th {
        border: 1px solid black;
        background-color: lightsteelblue;
        padding: 2px 20px;
    }
    td {
        border: 1px solid black;
    }
    label {
        padding: 2px 5px;
    }
</style>
</head>

<body>
<a href="<c:url value="/"/>" ><<< back to main page</a>
<h2>Список пользователей</h2>
<c:if test="${!empty userList}">
    <table style="">
        <tr>
            <th>П/П</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Дата рождения</th>
            <th>Телефон</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.birthDate}</td>
                <td>${user.telNumber}</td>
                <td><a href="<c:url value='/edit/${user.id}'/>"> Edit </a></td>
                <td><a href="<c:url value='/delete/${user.id}'/>"> Delete </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h2><c:out value="${user.id != null ? 'Редактировать': 'Добавить'}"/> пользователя</h2>
<form:form method="post" action="/users/add" modelAttribute="user">
    <table>
        <c:if test="${user.id != null}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="Id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" disabled="true"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="Фамилия"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="Имя"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="birthDate">
                    <spring:message text="Дата рождения"/>
                </form:label>
            </td>
            <td>
                <form:input path="birthDate"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="telNumber">
                    <spring:message text="Телефон"/>
                </form:label>
            </td>
            <td>
                <form:input  path="telNumber"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;">
                <input type="submit" value="<spring:message text="Добавить пользователя" /> "/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
