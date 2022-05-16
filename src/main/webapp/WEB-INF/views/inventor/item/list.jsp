<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.item.list.label.name" path="name"/>
	<acme:list-column code="inventor.item.list.label.retailPrice" path="retailPrice"/>
	<acme:list-column code="inventor.item.list.label.type" path="type"/>
	<acme:list-column code="inventor.item.list.label.published" path="published"/>
	
</acme:list>

<acme:button code="inventor.item.list.button.create" action="/inventor/item/create"/>