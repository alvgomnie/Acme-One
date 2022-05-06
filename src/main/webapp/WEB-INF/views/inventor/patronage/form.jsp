<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<h1>Patronage</h1>
	<acme:input-textbox code="inventor.patronages.form.label.code" path="code" readonly="true"/>
	<acme:input-textarea code="inventor.patronages.form.label.legalStuff" path="legalStuff" readonly="true"/>
	<acme:input-money code="inventor.patronages.form.label.budget" path="budget" readonly="true"/>
	<acme:input-moment code="inventor.patronages.form.label.startingDate" path="startingDate" readonly="true"/>
	<acme:input-moment code="inventor.patronages.form.label.finishingDate" path="finishingDate" readonly="true"/>
	<acme:input-moment code="inventor.patronages.form.label.timeLapse" path="timeLapse" readonly="true"/>
	<acme:input-url code="inventor.patronages.form.label.link" path="link" readonly="true"/>
	
	<jstl:if test="${status != 'PROPOSED'}">
		<acme:input-textbox code="inventor.patronages.form.label.status" path="status" readonly="true"/><br>
	</jstl:if>
	
	<jstl:if test="${status == 'PROPOSED'}">
		<acme:input-select path="status" code="inventor.patronages.form.label.update-status">
			<acme:input-option code="PROPOSED" value="PROPOSED" selected="true"/>
			<acme:input-option code="ACCEPTED" value="ACCEPTED"/>
			<acme:input-option code="DENIED" value="DENIED"/>
		</acme:input-select><br>		
	</jstl:if>
	
	<acme:submit test="${acme:anyOf(command, 'show, update') && status == 'PROPOSED'}" 
		code="inventor.patronages.form.button.update" action="/inventor/patronage/update"/>
	
	<h1>Patron</h1>
	<acme:input-textbox code="inventor.patronages.patron.form.label.company" path="patron.company"/>
	<acme:input-textarea code="inventor.patronages.patron.form.label.statement" path="patron.statement"/>
	<acme:input-url code="inventor.patronages.patron.form.label.link" path="patron.link"/>
</acme:form>