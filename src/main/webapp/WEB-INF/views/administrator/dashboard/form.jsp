<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNComponents" path="totalNComponents"/>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNTools" path="totalNTools"/>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNPatronages" path="totalNPatronages"/>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNPatronagesByStatus" path="totalNPatronagesByStatus"/>
	<acme:input-textbox code="administrator.dashboard.form.label.averageRetailPriceComponentsByTechAndCurrency" path="averageRetailPriceComponentsByTechAndCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.averageRetailPriceToolByCurrency" path="averageRetailPriceToolByCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.averageBudgetPatronagesByStatus" path="averageBudgetPatronagesByStatus"/>
	<acme:input-textbox code="administrator.dashboard.form.label.deviationRetailPriceComponentByTechAndCurrency" path="deviationRetailPriceComponentByTechAndCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.deviationRetailPriceToolByCurrency" path="deviationRetailPriceToolByCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.deviationBudgetPatronagesByStatus" path="deviationBudgetPatronagesByStatus"/>
	<acme:input-textbox code="administrator.dashboard.form.label.minRetailPriceComponentByTechAndCurrency" path="minRetailPriceComponentByTechAndCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.minRetailPriceToolByCurrency" path="minRetailPriceToolByCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.minBudgetPatronagesByStatus" path="minBudgetPatronagesByStatus"/>
	<acme:input-textbox code="administrator.dashboard.form.label.maxRetailPriceComponentByTechAndCurrency" path="maxRetailPriceComponentByTechAndCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.maxRetailPriceToolByCurrency" path="maxRetailPriceToolByCurrency"/>
	<acme:input-textbox code="administrator.dashboard.form.label.maxBudgetPatronagesByStatus" path="maxBudgetPatronagesByStatus"/>
	

</acme:form>