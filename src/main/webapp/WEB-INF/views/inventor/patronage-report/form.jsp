<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.patronageReport.list.label.automaticSeqNumber" path="automaticSeqNumber"/>
	<acme:input-moment code="inventor.patronageReport.list.label.creationMoment" path="creationMoment"/>
	<acme:input-textbox code="inventor.patronageReport.list.label.memorandum" path="memorandum"/>
	<acme:input-url code="inventor.patronageReport.list.label.link" path="link"/>	
</acme:form>