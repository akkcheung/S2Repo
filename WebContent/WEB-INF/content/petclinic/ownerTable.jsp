<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:forEach var="i" begin="1" end="5"> --%>
<%--          Item <c:out value="${i}" /> --%>
<!-- 	<p> -->
<%-- </c:forEach> --%>

<c:forEach items="${result}" var="element"> 
  <tr>
    <td>
    	<a href="editOwner?id=<c:out value='${element.id}'/>" >${element.id}</a>
    </td>	
    <td>${element.firstName}</td>
    <td>${element.lastName}</td>
  </tr>
</c:forEach>
