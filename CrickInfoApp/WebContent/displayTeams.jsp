<%@page import="java.util.List,com.pragim.model.Teams,com.pragim.model.Players" %>

<%@include file="lib.jsp" %>
<%@include file="addTeam.jsp" %>
 
<%

List<Teams> teamList = (List<Teams>)session.getAttribute("teamlist");
List<Players> plyList = (List<Players>)request.getAttribute("playersList");
String message = (String)request.getAttribute("message");

%>


<head>


<style type="text/css">

.fa-trash{
	font-size: 40px;
}

.deleSty{
	height: 20px;
	widows: 100px;
	background-color: lime;
	font-size: 40px;
}
.custFont{
	font-size: 20px;
}

.myheader{
	margin-top: 10px;
}
.fa{

	font-size: 25px;
}

</style>

<script type="text/javascript">

setTimeout(function(){
    document.getElementById("delMsg").innerHTML = '';
}, 3000);

</script>

</head>

<%

	if(message!=null){
%>	<span id="delMsg" class="deleSty"><%=message %></span>

<%} %>
	


<div class="myheader">
	<span class="custFont">TeamList</span><button type="button" class="btn btn-info btn-lg pull-right" data-toggle="modal"
		data-target="#myModal">Add Team</button>
</div>
<table class="table table-hover">

	 <tr>
	    <th></th>
	    <th>TeamName</th>
	    <th>NoOfPly</th>
	    <th>Rank</th>
	    <th>Country</th>
 	 </tr>
	<%
	if(teamList!=null && teamList.size()>0){
		for(Teams team:teamList){
		
		%>
		<tr>
		
			<td><input type="checkbox" name="tid" value='<%=team.getTeamId()%>'/></td>
			<td><a href='plyersdata?teamId=<%=team.getTeamId()%>'><%=team.getTeamName()%></a></td>
			<td><%=team.getNo_of_players() %></td>
			<td><%=team.getRank() %></td>
			<td><%=team.getCountry() %></td>
			<td><a  class="fa fa-pencil-square-o" href="getdata?teamId=<%=team.getTeamId()%>&btnName=edit"></a></td>
			<td><a class="fa fa-trash" href="getdata?teamId=<%=team.getTeamId()%>&btnName=delete"></a></td>
		</tr>
	<%
		}
	}
	%>
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
		
			
			<td><input type="checkbox" name="pid" value=<%=players.getPlyId()%>></td>
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

