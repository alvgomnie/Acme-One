<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.patronages.list.label.status" path="status"/>
	<acme:list-column code="inventor.patronages.list.label.code" path="code"/>
	<acme:list-column code="inventor.patronages.list.label.legalStuff" path="legalStuff"/>
	<acme:list-column code="inventor.patronages.list.label.budget" path="budget"/>
	<acme:list-column code="inventor.patronages.list.label.startingDate" path="startingDate"/>
	<acme:list-column code="inventor.patronages.list.label.finishingDate" path="finishingDate"/>
	<acme:list-column code="inventor.patronages.list.label.link" path="link"/>
</acme:list> 