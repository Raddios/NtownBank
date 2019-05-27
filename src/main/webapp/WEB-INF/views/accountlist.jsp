<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accounts</title>
</head>
<body>
<h1>Счетов = ${accounts.size()}</h1>

<table style="border-style: solid">
    <tr>
        <td>ID</td>
        <td>Client ID</td>
        <td>Balance</td>
        <td>Increase</td>
        <td>Decrease</td>
    </tr>
    <c:forEach var="account" items="${accounts}">
        <tr>
            <td>${account.id}</td>
            <td>${account.clientId.id}</td>
            <td>${account.balance}</td>
            <td><a href="${pageContext.request.contextPath}/${account.id}/accountincrease">Add</a></td>
            <td><a href="${pageContext.request.contextPath}/${account.id}/accountdecrease">Withdraw</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="newaccount">New Account</a>
<a href="${pageContext.request.contextPath}/index">HOME</a>
</body>
</html>