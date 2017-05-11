<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>	
	<div id="beanInfo">

		<table>
			<tr>
				<td><spring:message code="label.name"/></td>
				<td>${bean.name}</td>
			</tr>
			<tr>
				<td><spring:message code="label.surname"/></td>
				<td>${bean.surname}</td>
			</tr>
			<tr>
				<td><spring:message code="label.email"/></td>
				<td>${bean.email}</td>
			</tr>
			<tr>
				<td><spring:message code="label.photo"/></td>
				<td><img src="${homeUrl}/users/photo/${bean.ID}" height="150" width="150"></img></td>
			</tr>	

			<tr>
				<td>
					<a href="${homeUrl}/users/edit/${bean.ID}"><spring:message code="label.edit"/></a>
				</td>
			</tr>

			<tr>
			<td>
				<form:form method="DELETE" action="${homeUrl}/users/delete/${bean.ID}">
				<input type="submit" value="<spring:message code="button.delete"/>"></form:form>
			</td>
			</tr>
		</table>
	</div>
</body>
</html>