<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'member.label', default: 'Member')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
  </head>
  <body>
    <a href="#show-member" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div id="show-member" class="content scaffold-show" role="main">
      <h1>Member: ${member.name}</h1>
      <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
      </g:if>
      <div>
        <ol class="property-list member">
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Name</span>
            <span class="property-value">${member.name}</span>
          </li>
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Username</span>
            <span class="property-value">${member.username}</span>
          </li>
        </ol>
      </div>
      <g:if test="${member.groups.size() > 0}">
        <div>
          <table>
            <thead>
              <tr>
                <th>Groups</th>
              </tr>
            </thead>
            <tbody>
              <g:each in="${member.groups}" var="group" status="i">
                <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
                  <td><g:link controller="memberGroup" action="show" id="${group.key}">${group.name}</g:link></td>
                </tr>
              </g:each>
            </tbody>
          </table>
        </div>
      </g:if>
      <g:if test="${member.repositories.size() > 0}">
        <div>
          <table>
            <thead>
              <tr>
                <th width="50%">Repositories</th>
                <th width="50%">Permission</th>
              </tr>
            </thead>
            <tbody>
              <g:each in="${member.repositories}" var="perm" status="i">
                <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
                  <td><g:link controller="repository" action="show" id="${perm.repository.key}">${perm.repository.name}</g:link></td>
                  <td>${perm.permission}</td>
                </tr>
              </g:each>
            </tbody>
          </table>
        </div>
      </g:if>
    </div>
  </body>
</html>
