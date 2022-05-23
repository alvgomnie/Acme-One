<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="patron.patronageReport.list.label.automaticSeqNum" path="automaticSeqNum"/>
	<acme:list-column code="patron.patronageReport.list.label.creationMoment" path="creationMoment"/>
	<acme:list-column code="patron.patronageReport.list.label.memorandum" path="memorandum"/>
	<acme:list-column code="patron.patronageReport.list.label.link" path="link"/>
</acme:list> 