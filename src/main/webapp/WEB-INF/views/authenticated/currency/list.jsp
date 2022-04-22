<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.currency.list.label.name" path="name" width="80%"/>
	<acme:list-column code="authenticated.currency.list.label.isDefault" path="isDefault" width="20%"/>
</acme:list> 