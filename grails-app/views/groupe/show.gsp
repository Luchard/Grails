<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainPage" />
        <g:set var="entityName" value="${message(code: 'groupe.label', default: 'Groupe')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-groupe" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index">Liste Groupe</g:link></li>
                <li><g:link class="create" action="create">Nouveau Groupe</g:link></li>
            </ul>
        </div>
        <div id="show-groupe" class="content scaffold-show" role="main">
            <h1>Détails Groupe</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <table>



                <tr>
                    <td>
                        <label> Nom : </label>
                    </td>
                    <td>
                        <f:display bean="groupe" property="nom" displayStyle="table"/>
                    </td>
                </tr>


                <tr>
                    <td>
                        <label> Description : </label>
                    </td>
                    <td>
                        <f:display bean="groupe" property="description" displayStyle="table"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label> Image : </label>
                    </td>
                    <td>
                        <f:display bean="groupe" property="image" displayStyle="table"/>

                    </td>
                </tr>

                <tr>
                    <td>
                        <label> Pois : </label>
                    </td>
                    <td>
                        <f:display bean="groupe" property="pois" displayStyle="table"/>

                    </td>
                </tr>
            </table>
            <g:form resource="${this.groupe}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.groupe}">Modifier</g:link>
                    <input class="delete" type="submit" value="Supprimer" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
