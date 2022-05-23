<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}"> 
	<acme:input-textbox code="authenticated.currency.form.label.name" path="name"/>
	<acme:input-textbox code="authenticated.currency.form.label.onDefault" path="onDefault"/>
	<acme:input-textbox code="authenticated.currency.form.label.aacepted" path="accepted"/>
</acme:form>

