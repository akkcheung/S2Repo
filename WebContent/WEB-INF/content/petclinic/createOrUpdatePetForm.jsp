<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>

<head></head>

<body>

<jsp:include page="common.jsp" />

<!-- <div class="col-sm-offset-1 col-sm-10"> -->
<div class="container">

	<jsp:include page="menu.jsp">
		<jsp:param name="select" value="findOwners"/>
	</jsp:include>
	
 		<br />  
		<h3><p class="text-center">Pet Information</p></h3>

		<br />
		<div id="message"></div>

		<form class="form-horizontal" id="form">

			<input type="hidden" name="pet.id" value="${pet.id}">
			<input type="hidden" name="pet.owner.id" value="${owner.id}">

			<div class="form-group">
				<label for="owner">Owner</label>
				<c:out value="${owner.firstName}"/>,<c:out value="${owner.lastName}" />
			</div>

			<div class="form-group">
				<label for="name">Pet Name </label> <input type="text"
					class="form-control" name="pet.name" id="name" value="${pet.name}">
			</div>

			<div class="form-group">
				<label for="birthday">Birth Date </label> 
				<!--  <input type="text"
					class="form-control" name="pet.birthDate" id="birthDate"
					value="${pet.birthday}"> 
				-->
				 <input type="text" class="form-control" id="birthday" name="pet.birthday" placeholder="YYYY/MM/DD" 
				 	value="${pet.birthday}" />
				 	
  			</div>

			<div class="form-group">
				<label for="type">Type </label> 
				<select name="pet.type.id">
					<c:forEach items="${petTypes}" var="type">
						<option value="${type.id}"
							${pet.type.id eq type.id ? 'selected' : ''}>${type.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">

				<button class="btn btn-default" type="submit"
					ic-post-to="./savePet.action"
					ic-target="#message" >

<%-- 					<c:set value="${pet.id}" var="var_id" /> --%>
<%-- 					<c:out value="${empty var_id ? 'Add': 'Update'}" /> --%>
					Save Pet
				</button>

				<a class="btn btn-default" href="./editOwner?id=<c:out value='${owner.id}'/>">Back</a>

			</div>
		</form>

	</div>

	<script>
    $(document).ready(function(){
      var date_input=$('input[name="pet.birthday"]'); //our date input has the name "date"
      // var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        //format: 'mm/dd/yyyy',
        format: 'yyyy-mm-dd',
        // container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })
	</script>

</body>
</html>