<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<div class="list">
		<ul id="menu">
			<c:forEach var="bean" items="${beans}">
				<li><a href="${homeUrl}/tasks/${bean.ID}">${bean.name}</a></li>
			</c:forEach>
		</ul>
	</div>
	<a href="${homeUrl}/tasks/new"><spring:message code="label.add"/></a>

</body>
</html>