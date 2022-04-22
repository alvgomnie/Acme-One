<%@ page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="patron.patronages.form.label.status" path="status"/>
	<acme:input-textbox code="patron.patronages.form.label.code" path="code"/>
	<acme:input-textbox code="patron.patronages.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="patron.patronages.form.label.budget" path="budget"/>
	<acme:input-moment code="patron.patronages.form.label.startingDate" path="startingDate"/>
	<acme:input-moment code="patron.patronages.form.label.finishingDate" path="finishingDate"/>
	<acme:input-url code="patron.patronages.form.label.link" path="link"/>

	<acme:button code="patron.patronage.form.button.inventor" action="/patron/inventor/show?inventorId=${inventorId}"/>
</acme:form> 