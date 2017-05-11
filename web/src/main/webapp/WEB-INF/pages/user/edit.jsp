<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<form:form modelAttribute="user" id="userForm" method="POST" action="/users"
		enctype="multipart/form-data">

		<form:hidden path="userID"/>

		<form:label path="name"><spring:message code="label.name"/></form:label>
		<form:input path="name" />
		<div>
			<form:errors path="name" cssClass="error" />
		</div>
		<p/>

		<form:label path="surname"><spring:message code="label.surname"/></form:label>
		<form:input path="surname" />
		<div>
			<form:errors path="surname" cssClass="error" />
		</div>
		<p/>

		<form:label path="email"><spring:message code="label.email"/></form:label>
		<form:input path="email"/>
		<div>
			<form:errors path="email" cssClass="error" />
		</div>
		<p/>

		<label for="file"><spring:message code="label.photo"/></label>
		<input name="file" type="file" />
		<p/>

		<button type="submit"><spring:message code="button.save"/></button>
		<button type="reset"><spring:message code="button.reset"/></button>
	</form:form>

</body>
</html>