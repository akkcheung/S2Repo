<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head></head>

<body>

	<jsp:include page="common.jsp" />

	<p></p>

<!-- 		<div class="col-lg-10 col-lg-offset-1"> -->

	<div class="container">

			<jsp:include page="menu.jsp">
				<jsp:param name="select" value="findVets" />
			</jsp:include>

			<br />
			<h3><p class="text-center">Veterinarians</p></h3>

			<h3>
				<span id="indicator" style="display: none"> 
				 	<i	class="fa fa-spinner fa-spin"></i> Searching...
				</span>
			</h3>
		

<!-- 		<div class="col-lg-4 col-lg-offset-1"> -->
			<input class="form-control" name="lastName"
				placeholder="Begin Typing To Search Vet with Last Name..."
				ic-post-to="./searchVets.action" ic-trigger-on="keyup changed"
				ic-trigger-delay="500ms" ic-target="#table-body"
				ic-indicator="#indicator" type="text"> <br />
<!-- 		</div> -->
		
<!-- 		<div class="col-lg-10 col-lg-offset-1"> -->
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Specialty</th>					
					</tr>
				</thead>
				<tbody id="table-body">
				</tbody>
			</table>

	</div>

</body>
</html>