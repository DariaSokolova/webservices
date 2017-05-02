<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="home_text" var="homeText" />
<spring:message code="label_en" var="labelEn" />
<spring:message code="label_ru" var="labelRu" />
<spring:url value="/" var="homeUrl" />
<spring:url value="" var="currentUrl" />

<div id="footer">

	<a href="${homeUrl}">${homeText}</a> | <a href="${currentUrl}?lang=en">${labelEn}</a>
	| <a href="${currentUrl}?lang=ru">${labelRu}</a> <br/>
	
	<a href="${currentUrl}?theme=standart"><spring:message code="label_theme_standart"/></a>
	| <a href="${currentUrl}?theme=custom"><spring:message code="label_theme_custom"/></a>

</div>
