<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="administrator.dashboard.form.label.componentsDataByTechnology" path="componentsDataByTechnology"/>
	<acme:input-textbox code="administrator.dashboard.form.label.componentsDataByCurrency" path="componentsDataByCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.toolsDataByCurrency" path="toolsDataByCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.numberDataPatronages" path="numberDataPatronages"/>

</acme:form>