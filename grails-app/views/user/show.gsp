<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainPage" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index">Liste Utilisateur</g:link></li>
                <li><g:link class="create" action="create">Nouvel Utilisateur</g:link></li>
            </ul>
        </div>
        <div id="show-user" class="content scaffold-show" role="main">
            <h1>Détails Utilisateur : ${user.prenom} ${user.nom}  </h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <table>



<tr>
    <td>
        <label> Prénom : </label>
    </td>
    <td>
        <f:display bean="user" property="prenom" displayStyle="table"/>
    </td>
</tr>
            <tr>
                <td>
                    <label> Nom : </label>
                </td>
                <td>
                    <f:display bean="user" property="nom" displayStyle="table"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label> Username : </label>
                </td>
                <td>
                    <f:display bean="user" property="username" displayStyle="table"/>

                </td>
            </tr>

            </table>


            <g:form resource="${this.user}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.user}">Modifier</g:link>
                    <input class="delete" type="submit" value="Supprimer" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
