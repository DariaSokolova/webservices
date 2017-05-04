<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page session="true"%>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<title><spring:message code="application.title"/></title>
	<link rel="stylesheet" type="text/css" media="screen" href="/css/default.css" />
	<spring:theme code="styleSheet" var="themeURL" />
	<spring:url value="/${themeURL}" var="appThemeURL" />
	<link rel="stylesheet" type="text/css" media="screen" href="${appThemeURL}" />		

</head>
	<body>
 	<div id="container">
			<tiles:insertAttribute name="header" ignore="true" />
			<tiles:insertAttribute name="sidebar" ignore="true" />
			
			<div id="content">
				<tiles:insertAttribute name="body" />
			</div>
	
			<tiles:insertAttribute name="footer" ignore="true" />
		</div>
	</body>
</html>
