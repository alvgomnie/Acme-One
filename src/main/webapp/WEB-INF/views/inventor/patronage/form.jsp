<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<h1>Patronage</h1>
	<acme:input-textbox code="inventor.patronages.list.label.status" path="status"/>
	<acme:input-textbox code="inventor.patronages.list.label.code" path="code"/>
	<acme:input-textarea code="inventor.patronages.list.label.legalStuff" path="stuff"/>
	<acme:input-money code="inventor.patronages.list.label.budget" path="budget"/>
	<acme:input-moment code="inventor.patronages.list.label.startingDate" path="startingDate"/>
	<acme:input-moment code="inventor.patronages.list.label.finishingDate" path="finishingDate"/>
	<acme:input-url code="inventor.patronages.list.label.link" path="link"/>
	
	<h1>Patron</h1>
	<acme:input-textbox code="inventor.patronages.patron.list.label.company" path="patron.company"/>
	<acme:input-textarea code="inventor.patronages.patron.list.label.statement" path="patron.statement"/>
	<acme:input-url code="inventor.patronages.patron.list.label.optionalLink" path="patron.link"/>
</acme:form>