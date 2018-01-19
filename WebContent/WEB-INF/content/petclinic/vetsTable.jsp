<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${vets}" var="vet"> 
  <tr>
<!--     <td> -->
<%--     	<a href="editOwner?id=<c:out value='${element.id}'/>" >${element.id}</a> --%>
<!--     </td>	 -->
    <td>${vet.firstName}, ${vet.lastName}</td>
    <c:forEach items="${vet.specialties}" var="specialty"> 
    	<td>${specialty.name}</td>
    </c:forEach>
  </tr>
</c:forEach>
