<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.chirp.list.label.title" path="title"/>
	<acme:list-column code="any.chirp.list.label.author" path="author"/>
	<acme:list-column code="any.chirp.list.label.moment" path="moment"/>
	<acme:list-column code="any.chirp.list.label.body" path="body"/>
	<acme:list-column code="any.chirp.list.label.email" path="email"/>
</acme:list>