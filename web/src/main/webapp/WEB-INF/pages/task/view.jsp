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
				<td><spring:message code="label.user"/></td>
				<td>${bean.user.name}</td>
			</tr>
			
			<tr>
				<td><spring:message code="label.description"/></td>
				<td>${bean.description}</td>
			</tr>
			<tr>
				<td><spring:message code="label.creationDate"/></td>
				<td>${bean.creationDate}</td>
			</tr>
			
			<tr>
				<td><spring:message code="label.deadLine"/></td>
				<td>${bean.deadLine}</td>
			</tr>

			<tr>
				<td>
					<a href="${homeUrl}/tasks/edit/${bean.ID}"><spring:message code="label.edit"/></a>
				</td>
			</tr>

			<tr>
			<td>
				<form:form method="DELETE" action="${homeUrl}/tasks/delete/${bean.ID}">
				<input type="submit" value="<spring:message code="button.delete"/>"></form:form>
			</td>
			</tr>
		</table>
	</div>
</body>
</html>