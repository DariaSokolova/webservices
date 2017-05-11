<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/" var="homeUrl" />
<spring:url value="" var="currentUrl" />

<div id="footer">

	<a href="${homeUrl}"><spring:message code="label.home" /></a> | <a href="${currentUrl}?lang=en"><spring:message code="label.en"/></a>
	| <a href="${currentUrl}?lang=ru"><spring:message code="label.ru"/></a> <br/>
	
	<a href="${currentUrl}?theme=standart"><spring:message code="label.theme.standart"/></a>
	| <a href="${currentUrl}?theme=custom"><spring:message code="label.theme.custom"/></a>

</div>
