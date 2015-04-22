<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'memberGroup.label', default: 'Group')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
  </head>
  <body>
    <a href="#list-memberGroup" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div id="list-memberGroup" class="content scaffold-list" role="main">
      <h1><g:message code="default.list.label" args="[entityName]" /></h1>
      <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
      </g:if>
      <table>
        <thead>
          <tr>
            <g:sortableColumn property="name" title="Name"/>
          </tr>
        </thead>
        <tbody>
          <g:each in="${memberGroupList}" var="group" status="i">
            <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
              <td><g:link action="show" id="${group.key}">${group.name}</g:link></td>
            </tr>
          </g:each>
        </tbody>
      </table>
    </div>
  </body>
</html>
