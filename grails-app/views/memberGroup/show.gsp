<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'memberGroup.label', default: 'MemberGroup')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
  </head>
  <body>
    <a href="#show-memberGroup" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div id="show-memberGroup" class="content scaffold-show" role="main">
      <h1>Group: ${memberGroup.name}</h1>
      <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
      </g:if>
      <g:if test="${memberGroup.members.size() > 0}">
        <div>
          <table>
            <thead>
              <tr>
                <th>Members</th>
              </tr>
            </thead>
            <tbody>
              <g:each in="${memberGroup.members}" var="member" status="i">
                <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
                  <td><g:link controller="member" action="show" id="${member.id}">${member.name}</g:link></td>
                </tr>
              </g:each>
            </tbody>
          </table>
        </div>
      </g:if>
      <g:if test="${memberGroup.repositories.size() > 0}">
        <div>
          <table>
            <thead>
              <tr>
                <th width="50%">Repositories</th>
                <th width="50%">Permission</th>
              </tr>
            </thead>
            <tbody>
              <g:each in="${memberGroup.repositories}" var="perm" status="i">
                <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
                  <td><g:link controller="repository" action="show" id="${perm.repository.id}">${perm.repository.name}</g:link></td>
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
