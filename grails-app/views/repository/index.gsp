<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-repository" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <!--
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                -->
                <li><g:link controller="repository">Repositories</g:link></li>
                <li><g:link controller="group">Groups</g:link></li>
                <li><g:link controller="member">Members</g:link></li>
            </ul>
        </div>
        <div id="list-repository" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <!--
            <f:table collection="${repositoryList}" />
            -->
            <table>
              <thead>
                <tr>
                  <g:sortableColumn property="name" title="Name"/>
                  <g:sortableColumn property="lastUpdated" title="Last Updated"/>
                </tr>
              </thead>
              <tbody>
                <g:each in="${repositoryList}" var="repo" status="i">
                  <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show" id="${repo.id}">${repo.name}</g:link></td>
                    <td>${repo.lastUpdated}</td>
                  </tr>
                </g:each>
              </tbody>
        </div>
    </body>
</html>
