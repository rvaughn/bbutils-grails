<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <title>Bitbucket Data Browser</title>
  </head>
  <body>
    <div id="summary" class="content scaffold-show" role="main">
      <h1>Bitbucket Statistics</h1>
      <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
      </g:if>
      <div>
        <ol class="property-list member">
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Repositories</span>
            <span class="property-value">${repositories.count}</span>
          </li>
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Members</span>
            <span class="property-value">${members.count}</span>
          </li>
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Groups</span>
            <span class="property-value">${groups.count}</span>
          </li>
        </ol>
      </div>
    </div>
  </body>
</html>
