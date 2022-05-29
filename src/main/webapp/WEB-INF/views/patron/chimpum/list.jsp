<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="patron.chimpum.form.label.title" path="title"/>
	<acme:list-column code="patron.chimpum.form.label.budget" path="budget"/>
	<acme:list-column code="patron.chimpum.form.label.creationMoment" path="creationMoment"/>
	
</acme:list>
<!--
<acme:button code="patron.chimpum.list.button.create" action="/patron/item/create"/>
 -->