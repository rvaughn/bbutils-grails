<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
  </head>
  <body>
    <a href="#show-repository" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div id="show-repository" class="content scaffold-show" role="main">
      <h1>Repository: ${repository.name}</h1>
      <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
      </g:if>
      <!--
      <f:display bean="repository" />
      -->
      <div>
        <ol class="property-list member">
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Name</span>
            <span class="property-value">${repository.name}</span>
          </li>
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Link</span>
            <span class="property-value"><a href="${repository.url}" target="_blank">${repository.url}</a></span>
          </li>
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Date Created</span>
            <span class="property-value">${repository.dateCreated}</span>
          </li>
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Last Updated</span>
            <span class="property-value">${repository.lastUpdated}</span>
          </li>
        </ol>
      </div>
      <g:if test="${repository.members.size() > 0}">
        <div>
          <table>
            <thead>
              <tr>
                <th width="50%">Members</th>
                <th width="50%">Permission</th>
              </tr>
            </thead>
            <tbody>
              <g:each in="${repository.members}" var="perm" status="i">
                <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
                  <td><g:link controller="member" action="show" id="${perm.member.id}">${perm.member.name}</g:link></td>
                  <td>${perm.permission}</td>
                </tr>
              </g:each>
            </tbody>
          </table>
        </div>
      </g:if>
      <g:if test="${repository.groups.size() > 0}">
        <div>
          <table>
            <thead>
              <tr>
                <th width="50%">Groups</th>
                <th width="50%">Permission</th>
              </tr>
            </thead>
            <tbody>
              <g:each in="${repository.groups}" var="perm" status="i">
                <tr class="${i % 2 == 0 ? 'even' : 'odd'}">
                  <td><g:link controller="memberGroup" action="show" id="${perm.group.id}">${perm.group.name}</g:link></td>
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
