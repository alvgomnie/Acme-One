<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.spam.list.label.spamTerm" path="spamTerm" width="50%"/>
	<acme:list-column code="authenticated.spam.list.label.isStrong" path="isStrong" width="20%"/>
	<acme:list-column code="authenticated.spam.list.label.threshold" path="threshold" width="30%"/>
</acme:list> 