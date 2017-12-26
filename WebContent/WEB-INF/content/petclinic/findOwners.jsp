<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head></head>

<body>

	<jsp:include page="common.jsp" />

	<p></p>

		<div class="col-lg-10 col-lg-offset-1">

			<jsp:include page="menu.jsp">
				<jsp:param name="select" value="findOwners" />
			</jsp:include>

			<h3>
				<span id="indicator" style="display: none"> 
				 	<i	class="fa fa-spinner fa-spin"></i> Searching...
				</span>
			</h3>
		</div>

		<div class="col-lg-4 col-lg-offset-1">
			<input class="form-control" name="lastName"
				placeholder="Begin Typing To Search Owner with Last Name..."
				ic-post-to="./searchOwners.action" ic-trigger-on="keyup changed"
				ic-trigger-delay="500ms" ic-target="#table-body"
				ic-indicator="#indicator" type="text"> <br />
		</div>
		
		<div class="col-lg-10 col-lg-offset-1">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody id="table-body">
				</tbody>
			</table>

			<br /> <a class="btn btn-default" href="newOwner">Add Owner</a>

		</div>


</body>
</html>