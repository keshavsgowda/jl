<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CalculateTax</title>
</head>
<body>
<%
int income = Integer.parseInt(request.getParameter("salary"));
double tax = 0;
if(income <= 100000){
	
}
if(income>100000 && income<500000){
	tax = (income-100000)*0.15;
}
if(income > 500000){
	tax = (income-500000)*0.20 + 400000*0.15;
}
%>
Tax:<%=tax%>
</body>
</html>