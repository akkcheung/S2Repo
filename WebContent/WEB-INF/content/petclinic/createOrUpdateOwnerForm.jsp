<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>

<head></head>

<body>

<jsp:include page="common.jsp" />



		<div class="col-lg-10 col-lg-offset-1">
		
		<jsp:include page="menu.jsp">
			<jsp:param name="select" value="findOwners"/>
		</jsp:include>
		
		<div id="message">
		</div>
		
		<form class="form-horizontal" id="form">
			
 			<input type="hidden" name="owner.id" value="${owner.id}"> 
			
			<div class="form-group">
				<div class="col-xs-5">
				<label for="firstName">First name </label> 
				<input type="text"
					class="form-control input-lg" name="owner.firstName" id="firstname"
					value="${owner.firstName}">
				</div>
				<div class="col-xs-5">
				<label for="lastName">Last name </label> 
				<input type="text"
					class="form-control input-sm" name="owner.lastName" id="lastname"
					value="${owner.lastName}">
				</div>
			</div>

		
			<div class="form-group form-group-sm">
			<div class="col-xs-10">
				<label for="address">Address </label> 
				<input type="text"
					class="form-control" name="owner.address" id="address" value="${owner.address}">
			</div>
			</div>

			<div class="form-group">
			<div class="col-xs-10">
				<label for="city">City </label> 
				<input type="text"
					class="form-control" name="owner.city" id="city" value="${owner.city}">
			</div>
			</div>

			<div class="form-group">
			<div class="col-xs-10">
				<label for="telephone">Telephone</label> 
				<input type="text"
					class="form-control" name="owner.telephone" id="telephone" value="${owner.telephone}">
			</div>
			</div>
			
			<div class="form-group">
				<div class="col-xs-10">
						
					<button class="btn btn-default" id="OwnerSave" type="submit" ic-post-to="./changeOwner.action" 
						ic-target="#message"
						ic-on-success='$( "#OwnerEdit" ).trigger( "click" );'
						>
						
						<c:set value="${owner.id}" var="var_id"/>
						<c:out value="${empty var_id ? 'Add': 'Update'}"/> Owner											
					</button>
				
<!-- 					<button class="btn btn-primary" id="OwnerEdit" type="button" >Edit Owner</button> -->
				
					<a class="btn btn-default" href="./findOwners">Cancel</a>
				
					<a class="btn btn-default" href="pet-new">Add Pet</a>
				</div>
			</div>
			
		</form>
		
		
		
	</div>

	
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${empty var_id}"> --%>
<!-- 			<script>
			$('#form').find('input, textarea, button, select').prop('disabled',false);	
 			</script> -->
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<!-- 			<script> 
 				$('#form').find('input, textarea, button, select').prop('disabled',true);
 				$('#OwnerEdit').prop('disabled', false);
				$('#OwnerSave').hide();				
 			</script> -->
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>

</body>

<!-- <script type="text/javascript">
// 	$(document).ready(function() {	
			
// 		$("#OwnerEdit").click(function(event) {
// 			//alert("button");	
// 			 if ($(this).text() == "Edit Owner") {
// 				$('#form').find('input, textarea, button, select').prop('disabled',false);	
// 				$(this).text('Cancel');
// 			} else {
// 				$('#form').find('input, textarea, button, select').prop('disabled',true);	
// 				$(this).text('Edit Owner');
// 			};
// 		});
		
// 	});
</script> -->

</html>