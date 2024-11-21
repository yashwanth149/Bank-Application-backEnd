<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="dataProcess" modelAttribute="bankData">
	<div>
		<h1>Main Branch Bank</h1>
		<form:label path="">BankId</form:label>
		<form:input path="bid" placeholder="" readonly="true" /><br>
		<form:label path="">Bank Name</form:label>	
		<form:input path="bname" placeholder="Bank Name"/><br>
		<form:label path="">Main Branch</form:label>
		<form:input path="mainBranch" placeholder="Main Branch"/><br>
		<form:input path="" type="submit" value="submit"/>
	</div>
	
	<div>
		
	</div>
</form:form>

</body>
</html>