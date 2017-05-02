<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<title><spring:message code="welcome_h3"/></title>
	<link rel="stylesheet" type="text/css" media="screen" href="<spring:theme code="styleSheet"/>" />	
<%--	<spring:theme code="styleSheet" var="app_css" />
	<spring:url value="/${app_css}" var="app_css_url" />
	<link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}" />		--%>

</head>
	<body>
 	<div id="page-container">
		<%--		<tiles:insertAttribute name="header" ignore="true" />
	--%>
			<tiles:insertAttribute name="sidebar" ignore="true" />
			
			<div id="content">
				<div class="padding">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
	
			<tiles:insertAttribute name="footer" ignore="true" />
		</div>
	</body>
</html>
