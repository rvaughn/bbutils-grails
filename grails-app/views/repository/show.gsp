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
  </body>
</html>
