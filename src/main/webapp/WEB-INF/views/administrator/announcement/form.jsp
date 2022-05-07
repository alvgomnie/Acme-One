<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="administrator.announcement.form.label.title" path="title"/>
	<acme:input-textbox code="administrator.announcement.form.label.creationMoment" path="creationMoment"/>	
	
	<acme:input-select code="administrator.announcement.form.label.critical" path="critical">
	
		<acme:input-option code="NOT CRITICAL" value="false" selected="${critical == false}"/>
		<acme:input-option code="CRITICAL" value="true" selected="${critical == true}"/>
		
	</acme:input-select>
	
	<acme:input-textarea code="administrator.announcement.form.label.body" path="body"/>
	<acme:input-textbox code="administrator.announcement.form.label.link" path="link"/>
	
	<acme:input-checkbox code="administrator.announcement.form.label.confirmation" path="confirmation"/>	
	<acme:submit test="${command == 'create'}" code="administrator.announcement.form.button.create" action="/administrator/announcement/create"/>
</acme:form> 