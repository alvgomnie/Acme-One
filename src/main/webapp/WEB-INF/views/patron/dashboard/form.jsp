<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="patron.dashboard.form.label.totalNProposedPatronages" path="totalNProposedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.totalNAcceptedPatronages" path="totalNAcceptedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.totalNDeniedPatronages" path="totalNDeniedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.averageBudgetProposedPatronages" path="averageBudgetProposedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.averageBudgetAcceptedPatronages" path="averageBudgetAcceptedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.averageBudgetDeniedPatronages" path="averageBudgetDeniedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.deviationBudgetProposedPatronages" path="deviationBudgetProposedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.deviationBudgetAcceptedPatronages" path="deviationBudgetAcceptedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.deviationBudgetDeniedPatronages" path="deviationBudgetDeniedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.minBudgetProposedPatronages" path="minBudgetProposedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.minBudgetAcceptedPatronages" path="minBudgetAcceptedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.minBudgetDeniedPatronages" path="minBudgetDeniedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.maxBudgetProposedPatronages" path="maxBudgetProposedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.maxBudgetAcceptedPatronages" path="maxBudgetAcceptedPatronages"/>
	<acme:input-textbox code="patron.dashboard.form.label.maxBudgetDeniedPatronages" path="maxBudgetDeniedPatronages"/>

</acme:form>