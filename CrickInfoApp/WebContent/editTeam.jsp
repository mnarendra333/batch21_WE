 <head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head> 

<%@page import="com.pragim.model.Teams" %>



<%

	Teams team = (Teams)request.getAttribute("teamObj");

%>





<div class="container">

	<!-- Trigger the modal with a button -->


	<!-- Modal -->
	<form action="getdata">

		<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Add Team</h4>
					</div>
					<input type="hidden" value=<%=team.getTeamId() %> name="teamId"/>
					<div class="modal-body">
						<div class="form-group">
							<label for="usr">Team Name:</label> <input type="text"
								class="form-control" name="tname" value=<%=team.getTeamName() %>>
						</div>
						<div class="form-group">
							<label for="pwd">country:</label> <input type="text"
								class="form-control" name="country" value=<%=team.getCountry() %>>
						</div>
						<div class="form-group">
							<label for="pwd">NOP:</label> <input type="number"
								class="form-control" name="nop" value=<%=team.getNo_of_players() %>> 
						</div>
						<div class="form-group">
							<label for="pwd">Rank:</label> <input type="number"
								class="form-control" name="rank" value=<%=team.getRank() %>>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" value="update" name="btnName" class="btn btn-primary pull-left">Update</button>
					</div>

				</div>

	</form>

</div>