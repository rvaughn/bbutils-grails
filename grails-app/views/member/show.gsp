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
      <!--
      <f:display bean="member" />
      -->
    </div>
  </body>
</html>
