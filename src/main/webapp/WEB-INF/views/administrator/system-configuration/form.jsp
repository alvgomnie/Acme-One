<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="administrator.system-configuration.form.label.defaultCurrency" path="defaultCurrency"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.acceptedCurrenciesList" path="acceptedCurrenciesList"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strongSpamTermsList" path="strongSpamTermsList"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strongSpamTermsTranslate" path="strongSpamTermsTranslate"/>
	<acme:input-double code="administrator.system-configuration.form.label.strongSpamTreshold" path="strongSpamTreshold"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.weakSpamTermsList" path="weakSpamTermsList"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.weakSpamTermsTranslate" path="weakSpamTermsTranslate"/>
	<acme:input-double code="administrator.system-configuration.form.label.weakSpamThreshold" path="weakSpamThreshold"/>
	

</acme:form>