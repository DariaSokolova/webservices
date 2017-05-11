<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<form:form modelAttribute="task" id="taskForm" method="POST" action="/tasks">

		<form:hidden path="taskID"/>

		<form:label path="name"><spring:message code="label.title"/></form:label>
		<form:input path="name" />
		<div>
			<form:errors path="name" cssClass="error" />
		</div>
		<p/>
		
		<form:label path="user.userID"><spring:message code="label.user"/></form:label>
		<form:select path="user.userID">
   			<c:forEach var="user" items="${users}">
    			<form:option value="${user.userID}">${user.name}</form:option>
			</c:forEach>
  		</form:select>
  		<div>
			<form:errors path="user.userID" cssClass="error" />
		</div>
  		
  		<%-- 
		<form:label path="user.userID"><spring:message code="label.user"/></form:label>
		<form:input path="user.userID" />
		<div>
			<form:errors path="user.userID" cssClass="error" />
		</div>
		<p/>--%>

		<form:label path="description"><spring:message code="label.description"/></form:label>
		<form:input path="description" />
		<div>
			<form:errors path="description" cssClass="error" />
		</div>
		<p/>

		<form:label path="creationDate"><spring:message code="label.creationDate"/></form:label>
		<form:input path="creationDate"/>
		<div>
			<form:errors path="creationDate" cssClass="error" />
		</div>
		<p/>

		<form:label path="deadLine"><spring:message code="label.deadLine"/></form:label>
		<form:input path="deadLine"/>
		<div>
			<form:errors path="deadLine" cssClass="error" />
		</div>
		<p/>

		<button type="submit"><spring:message code="button.save"/></button>
		<button type="reset"><spring:message code="button.reset"/></button>
	</form:form>

</body>
</html>