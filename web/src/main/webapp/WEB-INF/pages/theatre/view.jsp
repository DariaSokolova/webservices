<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<table>
		<thead>
			<tr>
				<th width="50%"></th>
				<th width="50%"></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${bean.title}</td>
				<td>${bean.summary}</td>
			</tr>
		</tbody>
	</table>

</body>
</html>