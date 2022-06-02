<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNComponents" path="totalNComponents"/>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNTools" path="totalNTools"/>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNPatronages" path=""/>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNPatronagesByStatus" path=""/>
	<acme:input-textbox code="administrator.dashboard.form.label.averageRetailPriceComponentsByTechAndCurrency" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	
	
	
	<acme:input-textbox code="" path="ratio"/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	<acme:input-textbox code="" path=""/>
	
	
	
	
	

</acme:form>




<table class="table table-sm">

  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.totalNComponents"
      />
    </th>
    <td>
      <acme:print value="${totalNComponents}" />
    </td>
  </tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.totalNTools"
      />
    </th>
    <td>
      <acme:print value="${totalNTools}" />
    </td>
  </tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.totalNPatronages"
      />
    </th>
    <td>
      <acme:print value="${totalNPatronages}" />
    </td>
  </tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.totalNPatronagesByStatus"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${totalNPatronagesByStatus}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.averageRetailPriceComponentsByTechAndCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${averageRetailPriceComponentsByTechAndCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>

  <tr></tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.averageRetailPriceToolByCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${averageRetailPriceToolByCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.averageBudgetPatronagesByStatus"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${averageBudgetPatronagesByStatus}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>

  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.deviationRetailPriceComponentByTechAndCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${deviationRetailPriceComponentByTechAndCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>

  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.deviationRetailPriceToolByCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${deviationRetailPriceToolByCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.deviationBudgetPatronagesByStatus"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${deviationBudgetPatronagesByStatus}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>

  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.minRetailPriceComponentByTechAndCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${minRetailPriceComponentByTechAndCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>

  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.minRetailPriceToolByCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${minRetailPriceToolByCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.minBudgetPatronagesByStatus"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${minBudgetPatronagesByStatus}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>

  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.maxRetailPriceComponentByTechAndCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${maxRetailPriceComponentByTechAndCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>

  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.maxRetailPriceToolByCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${maxRetailPriceToolByCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.maxBudgetPatronagesByStatus"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${maxBudgetPatronagesByStatus}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  
  <!-- ------------------------------ Control check ----------------------- -->
  <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.ratio"
      />
    </th>
    <td>
      <acme:print value="${ratio}" />
    </td>
  </tr>
  <tr>
  	<tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.averageBudgetByCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${averageBudgetByCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
  	<tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.deviationBudgetByCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${deviationBudgetByCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
    <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.minBudgetByCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${minBudgetByCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
    <tr>
    <th scope="row">
      <acme:message
        code="administrator.dashboard.form.label.maxBudgetByCurrency"
      />
    </th>
    <td>
      <jstl:forEach
        var="entry"
        items="${maxBudgetByCurrency}"
      >
        <acme:print value="${entry.key}:${entry.value} " />
      </jstl:forEach>
    </td>
  </tr>
  <tr>
    
  
  
<!-- ------------------------------ Control check ----------------------- -->

</table>




<acme:return/>