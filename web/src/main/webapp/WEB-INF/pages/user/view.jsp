<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<table>
		<thead>
			<tr>
				<th width="20%"></th>
				<th width="20%"></th>
				<th width="20%"></th>
				<th width="40%"></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${bean.name}</td>
				<td>${bean.surname}</td>
				<td>${bean.email}</td>
				<td><img src="${homeUrl}/users/photo/${bean.ID}" height="150" width="150"></img></td>
			</tr>
		</tbody>
	</table>
	<a href="${homeUrl}/users/edit/${bean.ID}"><spring:message code="label.user.edit"/></a>

</body>
</html>