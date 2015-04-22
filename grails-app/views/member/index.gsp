<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'member.label', default: 'Member')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
  </head>
  <body>
    <a href="#list-member" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div id="list-member" class="content scaffold-list" role="main">
      <h1><g:message code="default.list.label" args="[entityName]" /></h1>
      <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
      </g:if>
      <table>
        <thead>
          <tr>
            <g:sortableColumn property="name" title="Name"/>
            <g:sortableColumn property="username" title="Username"/>
          </tr>
        </thead>
        <tbody>
          <g:each in="${memberList}" var="member" status="i">
            <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
              <td><g:link action="show" id="${member.id}">${member.name}</g:link></td>
              <td>${member.username}</td>
            </tr>
          </g:each>
        </tbody>
      </table>
    </div>
  </body>
</html>
