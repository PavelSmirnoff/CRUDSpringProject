<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
</head>
<body>
<c:forEach var="counter" begin="1" end="8">
    <c:out value="${counter}"/>
</c:forEach>
<h2>Список пользователей</h2>
    <table>
        <tr>
            <th>id</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Дата рождения</th>
            <th>Телефон</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.birthDate}</td>
                <td>${user.telNumber}</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
        </c:forEach>
    </table>

<h2>Добавить пользователя</h2>
<c:url var="addAction" value="/users"/>
<form:form method="post" action="users" modelAttribute="user">
    <table>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="First Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="Last Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="birthDate">
                    <spring:message text="Birth Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="birthDate"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="telNumber">
                    <spring:message text="Telephone"/>
                </form:label>
            </td>
            <td>
                <form:input path="telNumber"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="Добавить пользователя" /> "/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
