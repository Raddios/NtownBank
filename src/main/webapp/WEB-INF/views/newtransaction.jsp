<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New transaction</title>
</head>
<body>
<h1>New transaction</h1>
<f:form method="POST" commandName="transaction" action="transactions">
    <table>
        <tr>
            <td>
                <i>Sender Account ID:</i>
            </td>
            <td>
                <f:input path="senderId"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Recipient Account ID:</i>
            </td>
            <td>
                <f:input path="recipientId"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>summ Of Transaction:</i>
            </td>
            <td>
                <f:input path="summOfTransaction"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>
<a href="index">HOME</a>
</body>
</html>
