<%@page
	import="java.util.List,com.pragim.model.Teams,com.pragim.model.Players"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="lib.jsp"%>
<%@include file="addTeam.jsp"%>

<%

List<Teams> teamList = (List<Teams>)session.getAttribute("teamlist");

pageContext.setAttribute("teamList", teamList);
List<Players> plyList = (List<Players>)request.getAttribute("playersList");
String message = (String)request.getAttribute("message");
pageContext.setAttribute("message", message);

%>


<head>


<style type="text/css">
.fa-trash {
	font-size: 40px;
}

.deleSty {
	height: 20px;
	widows: 100px;
	background-color: lime;
	font-size: 40px;
}

.custFont {
	font-size: 20px;
}

.myheader {
	margin-top: 10px;
}

.fa {
	font-size: 25px;
}
</style>

<script type="text/javascript">

setTimeout(function(){
    document.getElementById("delMsg").innerHTML = '';
}, 3000);

</script>

</head>
<c:if test="${not empty message }">
	<span id="delMsg" class="deleSty">${message}</span>
</c:if>





<div class="myheader">
	<span class="custFont">TeamList</span>
	<button type="button" class="btn btn-info btn-lg pull-right"
		data-toggle="modal" data-target="#myModal">Add Team</button>
</div>
<table class="table table-hover">

	<tr>
		<th></th>
		<th>TeamName</th>
		<th>NoOfPly</th>
		<th>Rank</th>
		<th>Country</th>
	</tr>



	<c:if test="${not empty teamList}">
		<c:forEach items="${teamList}" var="team">
			<tr>

				<td><input type="checkbox" name="tid" value='${team.teamId}' /></td>
				<td><a href='plyersdata?teamId=${team.teamId}'>${team.teamName}</a></td>
				<td>${team.no_of_players}</td>
				<td>${team.country}</td>
				<td>${team.rank}</td>
				<td><a class="fa fa-pencil-square-o"
					href="getdata?teamId=${team.teamId}&btnName=edit"></a></td>
				<td><a class="fa fa-trash"
					href="getdata?teamId=${team.teamId}&btnName=delete"></a></td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<%
	if(plyList!=null && plyList.size()>0){

		%>
<h2 style="text-align: center">Players List</h2>
<table class="table table-hover">

	<tr>
		<th></th>
		<th>PlayerName</th>
		<th>age</th>
		<th>NOW</th>
		<th>skill</th>
		<th>rank</th>
	</tr>

	<%
		for(Players players:plyList){
		
		%>
	<tr>


		<td><input type="checkbox" name="pid"
			value=<%=players.getPlyId()%>></td>
		<td><%=players.getPlyName()%></td>
		<td><%=players.getNow() %></td>
		<td><%=players.getAge() %></td>
		<td><%=players.getSkill() %></td>
		<td><%=players.getRank() %></td>

	</tr>
	<%
		}
	}
	%>
</table>

