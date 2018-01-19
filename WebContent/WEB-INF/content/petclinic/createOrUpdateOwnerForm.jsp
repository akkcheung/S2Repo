<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>

<head></head>

<body>

<jsp:include page="common.jsp" />

<!-- 		<div class="col-lg-10 col-lg-offset-1"> -->

<div class="container">
		
		<jsp:include page="menu.jsp">
			<jsp:param name="select" value="findOwners"/>
		</jsp:include>
		
		<br />
		<h3><p class="text-center">Owner Information</p></h3>
		
		<div id="message">
		</div>
		
		<br />
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
						
					<button class="btn btn-default" id="OwnerSave" type="submit" ic-post-to="./saveOwner.action" 
						ic-target="#message"
						ic-on-success='$( "#OwnerEdit" ).trigger( "click" );'
						>
						
						<c:set value="${owner.id}" var="var_id"/>
<%-- 						<c:out value="${empty var_id ? 'Add': 'Update'}"/> --%>  
						Save Owner
					</button>
									
					<c:choose>
						<c:when test="${not empty var_id}">
							<a class="btn btn-default" href="./newPet?ownerId=${owner.id}">Add
								New Pet</a>
						</c:when>
					</c:choose>
					
					<a class="btn btn-default" href="./findOwners">Back</a>
				</div>
			</div>
			
		</form>
		
		<br />
		<h3><p class="text-center">Pets and Visits</p></h3>
		
		<br />		
		<table class="table table-hover">
		<c:forEach items="${owner.pets}" var="pet"> 
		  <tr>
		  	<td>
			    <br />Pet Name : ${pet.name}
			    <br />Birthday : ${pet.birthday}
			    <br />Type : ${pet.type.name}
			    <br />			 
			    <a class="btn btn-default" href="./editPet?id=${pet.id}&ownerId=${owner.id}">Edit Pet</a>
			 		    
		    </td>
		    <td>
		    	<table class="table table-hover">
		    	<thead>
					<tr>
		    		<th>Visit Date</th>
		    		<th>Description</th>
		    	</tr>
		    	<tbody>		    	
		    	<c:forEach items="${pet.visits}" var="visit">
		    	<tr>			 
				    <td> ${visit.date} </td>
				    <td> ${visit.description} </td>
				</tr>				
			    </c:forEach>
			    <tr>
					<td><a class="btn btn-default" href="./newVisit?petId=${pet.id}&ownerId=${owner.id}">Add Visit</a></td>
					<td></td>
				</tr> 
			    </tbody>
			    </table>
		    </td>
		  </tr>
		</c:forEach>
		</table>
		
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
<!-- </script> --> 

</html>