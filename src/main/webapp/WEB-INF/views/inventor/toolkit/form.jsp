<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}"> 
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-url code="inventor.toolkit.form.label.furtherInfo" path="furtherInfo"/>
	<acme:input-money code="inventor.toolkit.form.label.retailPrice" path ="retailPrice"/>
	<acme:input-textbox code="inventor.toolkit.form.label.currency" path ="currency"/>
	
	<acme:button code="inventor.toolkit.form.button.items" action="/inventor/item/list?masterId=${id}"/>			
		
</acme:form>