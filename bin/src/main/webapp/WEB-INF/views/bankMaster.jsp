<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chegusBoot.beans.DataBank" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bank Master</title>
</head>
<body>
    <a href="test">Bank Master</a>

    <table>
        <c:if test="${not empty banks}">
            <c:forEach var="bank" items="${banks}">
                <tr>
                    <td>${bank.bid}</td>
                    <td>${bank.bname}</td>
                    <td>${bank.mainBranch}</td>
                    <td><a href="update?id=${bank.bid}">edit</a></td>
                    <td><a href="delete?id=${bank.bid}">remove</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty banks}">
            <tr>
                <td colspan="5">No records found</td>
            </tr>
        </c:if>
    </table>
</body>
</html>
