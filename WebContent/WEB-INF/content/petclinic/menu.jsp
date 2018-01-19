<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default">
	<!-- <div class="container-fluid"> -->

	<div class="center-block">

		<div class="navbar-header">
			<a class="navbar-brand" href="./">Pet Clinic				
			</a>
		</div>

		<div>
			<ul class="nav navbar-nav">
				<li><a href="./findOwners">Owners</a></li>
				<li><a href="./findVets">Veterinarians</a></li>
				<li><a href="#">About</a></li>
			</ul>
		</div>
	</div>
</nav>



<%-- <c:out value="${param.select}" /> --%>

<script>
		$('a[href="./${param.select}"]').parents('li,ul').addClass('active');
</script>