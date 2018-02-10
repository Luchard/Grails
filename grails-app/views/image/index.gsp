<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainPage" />
        <g:set var="entityName" value="${message(code: 'image.label', default: 'Image')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-image" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">Nouvelle Image</g:link></li>
            </ul>
        </div>
        <div id="list-image" class="content scaffold-list" role="main">
            <h1>Liste Image</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${imageList}" properties="['fileName','contentType']" />

            <div class="pagination">
                <g:paginate total="${imageCount ?: 0}" />
            </div>
        </div>
    </body>
</html>