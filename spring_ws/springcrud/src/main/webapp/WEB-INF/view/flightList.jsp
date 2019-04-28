
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%-- <c:out value="${list}"></c:out> --%>

<head>
	 <style type="text/css">
            .error {
                color: red;
            }
            table {
                width: 50%;
                border-collapse: collapse;
                border-spacing: 0px;
            }
            table td {
                border: 1px solid #565454;
                padding: 20px;
            }
        </style>

</head>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="add" method="post" modelAttribute="flightform">
           <form:hidden path="id"/> 
            <table>
                <tr>
                    <td>FlghtId</td>
                   
                    <td>
                        <form:input path="flightId"/> <br />
                        <form:errors path="flightId" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>FlightName</td>
                    <td>
                        <form:input path="flightName" /> <br />
                        <form:errors path="flightName" cssClass="error" />
                    </td>
                </tr>
                 <tr>
                    <td>Dep.time</td>
                   
                    <td>
                    <fmt:formatDate pattern="dd-MM-yyyy" value="${flightform.departureTime}" var="custDate"/>
                        <form:input path="departureTime" value="${custDate}"/> <br />
                        
                        <form:errors path="departureTime" cssClass="error" />
                    </td>
                </tr>
                 <tr>
                    <td>Fare</td>
                    <td>
                        <form:input path="cost" /> <br />
                        <form:errors path="cost" cssClass="error" />
                    </td>
                </tr>
                <c:out value="data is ${flightform.flightName}"/>
                
                <c:choose>
                <c:when test="${empty flightform.flightName}">
                <tr>
                    <td colspan="2"><button type="submit">Add</button></td>
                </tr>
                </c:when>
                <c:otherwise>
                <tr>
                    <td colspan="2"><button type="submit">Update</button></td>
                </tr>
                </c:otherwise>
                </c:choose>
            </table>
        </form:form>
         










<br>
<br>

<table class="table table-hover">
<c:forEach items="${list}" var="flight">
	
	<tr>
		<td><input type="checkbox"></input></td>
		<td>${flight.id }</td>
		<td>${flight.flightId }</td>
		<td>${flight.flightName }</td>
		<td>${flight.departureTime }</td>
		<td>${flight.cost }</td>
		<td><a href="delete/${flight.id}">delete</a></td>
		<td><a href="fetchbyid?id=${flight.id}">edit</a></td>
	
	</tr>

</c:forEach>

</table>