<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
  </head>
  <body>
    <a href="#list-repository" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div id="list-repository" class="content scaffold-list" role="main">
      <h1><g:message code="default.list.label" args="[entityName]" /></h1>
      <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
      </g:if>
      <table>
        <thead>
          <tr>
            <!-- does not work with REST resources
            <g:sortableColumn property="name" title="Name"/>
            <g:sortableColumn property="lastUpdated" title="Last Updated"/>
            -->
            <th class="sortable ${params.sort == 'name' ? params.order : ''}"><g:link resource="repository" params="[sort: 'name', order: params.sort == 'name' && params.order == 'asc' ? 'desc' : 'asc']">Name</g:link></th>
            <th class="sortable ${params.sort == 'lastUpdated' ? params.order : ''}"><g:link resource="repository" params="[sort: 'lastUpdated', order: params.sort == 'lastUpdated' && params.order == 'asc' ? 'desc' : 'asc']">Last Updated</g:link></th>
          </tr>
        </thead>
        <tbody>
          <g:each in="${repositoryList}" var="repo" status="i">
            <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
              <td><g:link action="show" id="${repo.key}">${repo.name}</g:link></td>
              <td>${repo.lastUpdated}</td>
            </tr>
          </g:each>
        </tbody>
      </table>
    </div>
  </body>
</html>
