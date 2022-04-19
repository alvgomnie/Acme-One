<%@ page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code = "inventor.item.list.label.name" path ="name" />
	<acme:list-column code = "inventor.item.list.label.code" path ="code" />
	<acme:list-column code = "inventor.item.list.label.itemType" path ="itemType" />
</acme:list>