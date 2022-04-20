<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="patron.patronage-report.list.label.automaticSeqNumber" path="automaticSeqNumber"/>
	<acme:input-moment code="patron.patronage-report.list.label.creationMoment" path="creationMoment"/>
	<acme:input-textbox code="patron.patronage-report.list.label.memorandum" path="memorandum"/>
	<acme:input-url code="patron.patronage-report.list.label.link" path="link"/>	
</acme:form>