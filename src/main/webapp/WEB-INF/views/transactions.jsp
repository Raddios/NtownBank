<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Transactions</title>
</head>
<body>
	<h1>
		Transactions count :
		<c:out value="${transactions.size()}"></c:out>
	</h1>
	
	<table style="border-style: solid">
		<tr>
			<td>ID</td>
			<td>Sender Account ID</td>
			<td>Recipient Account ID</td>
			<td>Summ of transaction</td>
			<td>Date of transaction</td>
		</tr>
		<c:forEach var="transaction" items="${transactions }">
			<tr>
				<td><c:out value="${transaction.id}"></c:out></td>
				<td><c:out value="${transaction.senderId}"></c:out></td>
				<td><c:out value="${transaction.recipientId}"></c:out></td>
				<td><c:out value="${transaction.summOfTransaction}"></c:out></td>
				<td><c:out value="${transaction.dateOfTransaction}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="newtransaction">New transaction</a>
	<a href="index">HOME</a>

</body>
</html>