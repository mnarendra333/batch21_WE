<div class="container">

	<!-- Trigger the modal with a button -->


	<!-- Modal -->
	<form action="getdata">


		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Add Team</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="usr">Team Name:</label> <input type="text"
								class="form-control" name="tname">
						</div>
						<div class="form-group">
							<label for="pwd">country:</label> <input type="text"
								class="form-control" name="country">
						</div>
						<div class="form-group">
							<label for="pwd">NOP:</label> <input type="number"
								class="form-control" name="nop">
						</div>
						<div class="form-group">
							<label for="pwd">Rank:</label> <input type="number"
								class="form-control" name="rank">
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" value="add" name="btnName" class="btn btn-primary pull-left">Add</button>
					</div>

				</div>

			</div>
		</div>

	</form>

</div>