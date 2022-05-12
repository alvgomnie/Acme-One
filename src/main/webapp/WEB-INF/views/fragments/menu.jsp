<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.roles.Provider,acme.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.link.alvgomnie" action="http://www.github.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.link.juacasalb" action="https://es.wikipedia.org/wiki/Canis_familiaris"/>
			<acme:menu-suboption code="master.menu.anonymous.link.fraprapra1" action="https://elpais.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.link.miggavmar" action="https://okdiario.com/"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.any.chirps">
			<acme:menu-suboption code="master.menu.any.chirps.list" action="/any/chirp/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.any.items">
			<acme:menu-suboption code="master.menu.any.items.components" action="/any/item/list?type=component"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.items.tools" action="/any/item/list?type=tool"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.any.toolkits">
			<acme:menu-suboption code="master.menu.any.toolkits.list" action="/any/toolkit/list"/>		
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.any.user-account">
			<acme:menu-suboption code="master.menu.any.user-account.consumer" action="/any/user-account/list?role=consumer"/>
			<acme:menu-suboption code="master.menu.any.user-account.inventor" action="/any/user-account/list?role=inventor"/>
			<acme:menu-suboption code="master.menu.any.user-account.patron" action="/any/user-account/list?role=patron"/>
			<acme:menu-suboption code="master.menu.any.user-account.provider" action="/any/user-account/list?role=provider"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.announcement" action="/administrator/announcement/create"/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.inventor" access="hasRole('Inventor')">
			<acme:menu-suboption code="master.menu.inventor.components-link" action="/inventor/item/list-my-components"/>
			<acme:menu-suboption code="master.menu.inventor.tools-link" action="/inventor/item/list-my-tools"/>
			<acme:menu-suboption code = "master.menu.inventor.toolkit" action = "/inventor/toolkit/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code = "master.menu.inventor.patronageReport-create" action="/inventor/patronage-report/create"/>
			<acme:menu-suboption code = "master.menu.inventor.patronages" action = "/inventor/patronage/list"/>
			<acme:menu-suboption code = "master.menu.inventor.patronageReport-list" action = "/inventor/patronage-report/list"/>
    	</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.patronages" action="/patron/patronage/list"/>
			<acme:menu-suboption code="master.menu.patron.patronageReport" action="/patron/patronage-report/list"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-inventor" action="/authenticated/inventor/create" access="!hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.inventor" action="/authenticated/inventor/update" access="hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.become-patron" action="/authenticated/patron/create" access="!hasRole('Patron')"/>
			<acme:menu-suboption code="master.menu.user-account.patron" action="/authenticated/patron/update" access="hasRole('Patron')"/>
			<acme:menu-suboption code="master.menu.user-account.announcements.list" action="/authenticated/announcement/list"/>
			<acme:menu-suboption code="master.menu.authenticated.configuration.list-spam" action="/authenticated/spam/list"/>
			<acme:menu-suboption code="master.menu.authenticated.configuration.list-currency" action="/authenticated/currency/list"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

