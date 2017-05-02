<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<div class="list">
		<ul id="menu">
			<c:forEach var="bean" items="${beans}">
				<li><a href="${homeUrl}/theatres/${bean.id}">${bean.title}</a></li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>