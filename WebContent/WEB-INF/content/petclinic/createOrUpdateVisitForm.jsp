<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head></head>

<body>

	<jsp:include page="common.jsp" />

	<div class="container">
		<jsp:include page="menu.jsp">
			<jsp:param name="select" value="findOwners" />
		</jsp:include>

		<br />
		<h3><p class="text-center">Visit Information</p></h3>

		<br />
		<div id="message"></div>

		<br />
		<table class="table table-hover">
			<thead>
					<tr>
						<th>Pet Name</th>
						<th>Birthday</th>
						<th>Type</th>
						<th>Owner</th>
					</tr>
				</thead>
				<tbody id="table-body">
				<tr>
    				<td>${pet.name}</td>
					<td>${pet.birthday}</td>
					<td>${pet.type.name}</td>
					<td>${owner.lastName}, ${owner.firstName}</td>
				</tr>
				</tbody>
		</table>

		<form class="form-horizontal" id="form">

			<input type="hidden" name="pet.id" value="${pet.id}">
			<input
				type="hidden" name="pet.owner.id" value="${owner.id}">

			<div class="form-group">
				<label for="date">Date </label>
				<input type="text"
					class="form-control" id="date" name="visit.date"
					placeholder="YYYY/MM/DD" value="${visit.date}" />
			</div>

			<div class="form-group">
				<label for="description">Description </label>
				<input type="text"
					class="form-control" name="visit.description" id="description"
					value="${visit.description}">
			</div>

			<div class="form-group">
				<button class="btn btn-default" type="submit"
					ic-post-to="./saveVisit.action" ic-target="#message">Save
					visit</button>
				<a class="btn btn-default"
					href="./editOwner?id=<c:out value='${owner.id}'/>">Back</a>
			</div>

		</form>
		
		<br />
		<h3>Previous Visits</h3>
		
		<br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Visit Date</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody id="table-body">
				<c:forEach items="${pet.visits}" var="visit">
					<tr>
						<td>${visit.date}</td>
						<td>${visit.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script>
		$(document).ready(function() {
			var date_input = $('input[name="visit.date"]');
			var options = {
				format : 'yyyy-mm-dd',
				todayHighlight : true,
				autoclose : true,
			};
			date_input.datepicker(options);
		})
	</script>

</body>
</html>