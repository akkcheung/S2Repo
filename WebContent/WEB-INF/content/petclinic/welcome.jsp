<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head></head>

<body>

	<jsp:include page="common.jsp" />

	<!-- 	<div class="vertical-center"> -->
	<!-- 		<div class="container"> -->

	<div class="col-lg-10 col-lg-offset-1 text-center">
			<jsp:include page="menu.jsp">
				<jsp:param name="select" value="home" />
			</jsp:include>



			<h3>Welcome !</h3>


	</div>
</body>



</html>