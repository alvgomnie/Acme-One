<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="patron.chimpum.form.label.title" path="title"/>
	<acme:input-textbox code="patron.chimpum.form.label.code" path="code"/>
	<acme:input-textarea code="patron.chimpum.form.label.description" path="description"/>
	<acme:input-money code="patron.chimpum.form.label.budget" path="budget"/>
	<acme:input-moment code="patron.chimpum.form.label.creationMoment" path="creationMoment"/>
	<acme:input-moment code="patron.chimpum.form.label.finishingDate" path="finishingDate"/>
	<acme:input-url code="patron.chimpum.form.label.link" path="link"/>
	<acme:input-textbox code="patron.chimpum.form.label.item.type" path="itemType"/>
	
	<%--
	<acme:input-select code="patron.chimpum.list.label.item" path="itemId">
		<jstl:forEach items="${items}" var="item">
			<acme:input-option code="${item.getId()}" value="${item.getId()}" selected="${item.getId() == itemId}"/>
		</jstl:forEach>
	</acme:input-select>

	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update, delete)}">
			<acme:submit code="patron.chimpum.form.button.update" action="/patron/chimpum/update"/>
			<acme:submit code="patron.chimpum.form.button.delete" action="/patron/chimpum/delete"/>
		</jstl:when>	

		<jstl:when test="${command == 'create'}">
			<acme:submit code="patron.chimpum.form.button.create" action="/patron/chimpum/create"/>
		</jstl:when>
	</jstl:choose>
	--%>

</acme:form>