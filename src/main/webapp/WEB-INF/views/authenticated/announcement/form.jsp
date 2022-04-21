<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}"> 
	<acme:input-textbox code="authenticated.announcement.list.label.title" path="title"/>
	<acme:input-textbox code="authenticated.announcement.list.label.creationMoment" path="creationMoment"/>
	<acme:input-textbox code="authenticated.announcement.list.label.body" path="body"/>
	<acme:input-textbox code="authenticated.announcement.list.label.link" path="link"/>
</acme:form>
