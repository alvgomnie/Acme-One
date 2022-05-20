<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form> 
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-select code="inventor.item.list.label.publish" path="publish">
		<acme:input-option code="true" value="true" selected="${publish == true}"/>
		<acme:input-option code="false" value="false" selected="${publish == false }"/>
	</acme:input-select>
	<acme:input-url code="inventor.toolkit.form.label.link" path ="link"/>		
	
	
	
	<jstl:choose>
	
		<jstl:when test="${acme:anyOf(command,'show, update, delete, publish' ) && publish == false}">
			<acme:submit code="inventor.toolkit.form.button.publish" action="/inventor/toolkit/publish"/>
			<acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update"/>
			<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
		</jstl:when>
		
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>
		</jstl:when>
		
	</jstl:choose>
	
	<jstl:if test="${command != 'create'}">
		<acme:button code="inventor.toolkit.form.button.item" action="/inventor/item/list-by-toolkit?id=${id}"/>
	</jstl:if>
	
	
		
		
</acme:form>

