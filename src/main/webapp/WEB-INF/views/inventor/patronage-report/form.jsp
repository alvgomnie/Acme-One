<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.patronageReport.form.label.automaticSeqNum" path="automaticSeqNum"/>
	<acme:input-moment code="inventor.patronageReport.form.label.creationMoment" path="creationMoment"/>
	<acme:input-textbox code="inventor.patronageReport.form.label.memorandum" path="memorandum"/>
	<acme:input-url code="inventor.patronageReport.form.label.link" path="link"/>
	
	<acme:input-select code="inventor.patronageReport.list.label.patronage" path="patronageId">
		<jstl:forEach items="${patronages}" var="patronage">
			<acme:input-option code="${patronage.getCode()}" value="${patronage.getId()}" selected="${patronage.getId() == patronageId}"/>
		</jstl:forEach>
	</acme:input-select>
	
	<acme:input-checkbox code="inventor.patronageReport.form.label.confirmation" path="confirmation"/>
	
	<jstl:if test="${command == 'create'}">
		<acme:submit code="inventor.patronageReport.form.button.create" action="/inventor/patronage-report/create"/>
	</jstl:if>
</acme:form>