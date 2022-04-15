<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="any.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="any.toolkit.form.label.code" path="code"/>
	<acme:input-textarea code="any.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="any.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-url code="any.toolkit.form.label.link" path="link"/>
	<acme:input-textbox code="any.toolkit.form.label.item.name" path="item.name"/>
	<acme:input-money code="any.toolkit.form.label.item.price" path="item.retailPrice"/>
	
	<acme:button code="any.toolkit.form.button.item" action="/any/item/show?itemId=${itemId}"/>
	
</acme:form>