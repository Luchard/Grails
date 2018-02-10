<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainPage" />
        <g:set var="entityName" value="${message(code: 'groupe.label', default: 'Groupe')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-groupe" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">Nouveau Groupe</g:link></li>
            </ul>
        </div>
        <div id="list-groupe" class="content scaffold-list" role="main">
            <h1>Liste Groupe</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${groupeList}" />

            <div class="pagination">
                <g:paginate total="${groupeCount ?: 0}" />
            </div>
        </div>
    </body>
</html>