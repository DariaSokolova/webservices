<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	User Page
	<div class="list">
		<ul id="menu">
			<c:forEach var="bean" items="${beans}">
				<li><a href="${homeUrl}/users/${bean.ID}">${bean.name}</a></li>
			</c:forEach>
		</ul>
	</div>
	<a href="${homeUrl}/users/new">Add User</a>

</body>
</html>