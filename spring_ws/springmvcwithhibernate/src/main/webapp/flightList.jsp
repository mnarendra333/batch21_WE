<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<table class="table table-hover">
<c:forEach items="${list}" var="flights">
	
	<tr>
	
		<td>${flights.flightId }</td>
		<td>${flights.flightName }</td>
		<td>${flights.departureTime }</td>
		<td>${flights.cost }</td>
	
	</tr>

</c:forEach>
</table>