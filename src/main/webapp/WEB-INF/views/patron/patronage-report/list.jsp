<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="patron.patronage-report.list.label.automaticSeqNumber" path="automaticSeqNumber"/>
	<acme:list-column code="patorn.patronage-report.list.label.creationMoment" path="creationMoment"/>
	<acme:list-column code="patron.patronage-report.list.label.memorandum" path="memorandum"/>
	<acme:list-column code="patron.patronage-report.list.label.link" path="link"/>
</acme:list> 