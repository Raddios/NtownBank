<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Clients</title>
</head>
<body>
	<h1>
		Clients count :
		<c:out value="${clients.size()}"></c:out>
	</h1>

	<table style="border-style: solid">
		<tr>
			<td>ID</td>
			<td>Имя</td>
			<td>Адрес</td>
			<td>Возраст</td>
		</tr>
		<c:forEach var="client" items="${clients }">
			<tr>
				<td><c:out value="${client.id}"></c:out></td>
				<td><a href="${client.id}/accountlist"><c:out value="${client.name}"></c:out></a></td>
				<td><c:out value="${client.adress}"></c:out></td>
				<td><c:out value="${client.age}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="newclient">New client</a>
	<a href="transactions">Transactions</a>

</body>
</html>