<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainPage" />
        <g:set var="entityName" value="${message(code: 'image.label', default: 'Image')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-image" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index">Liste Image</g:link></li>
                <li><g:link class="create" action="create">Nouvelle Image</g:link></li>
            </ul>
        </div>
        <div id="show-image" class="content scaffold-show" role="main">
            <h1>Détails Image</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <table>



                <tr>
                    <td>
                        <label> Nom du fichier : </label>
                    </td>
                    <td>
                        <f:display bean="image" property="fileName" displayStyle="table"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label> Type du fichier : </label>
                    </td>
                    <td>
                        <f:display bean="image" property="contentType" displayStyle="table"/>
                    </td>
                </tr>

            </table>
            <img src="${createLink(controller: 'ImageController', action: 'viewImage', id: 1)}" />
            <g:form resource="${this.image}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.image}"><g:message code="default.button.edit.label" default="Edit" /></g:link>\

                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
