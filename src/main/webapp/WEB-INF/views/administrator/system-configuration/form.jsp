<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="administrator.system-configuration.form.label.systemCurrency" path="systemCurrency"/>	
	<acme:input-textbox code="administrator.system-configuration.form.label.acceptedCurrencies" path="acceptedCurrencies"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strongSpamTerms" path="strongSpamTerms"/>	
	<acme:input-textbox code="administrator.system-configuration.form.label.weakSpamTerms" path="weakSpamTerms"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strongSpamTreshold" path="strongSpamTreshold"/>	
	<acme:input-textbox code="administrator.system-configuration.form.label.weakSpamTreshold" path="weakSpamTreshold"/>

	<acme:submit code="administrator.system-configuration.form.button.update" action="/administrator/system-configuration/update"/>
</acme:form>