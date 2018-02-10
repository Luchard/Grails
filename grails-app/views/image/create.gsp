<%@ page import="projetpoiss.Image" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainPage" />
        <g:set var="entityName" value="${message(code: 'image.label', default: 'Image')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-image" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index">Liste Image</g:link></li>
            </ul>
        </div>
        <div id="create-image" class="content scaffold-create" role="main">
            <h1>Nouvelle Image</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.image}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.image}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form enctype="multipart/form-data" resource="${this.image}" method="POST">

                <tr class="prop">
                <td valign="top" class="name"><label for = 'dueDate'>File : </label>

                </td>
                   <td valign="top" class='value ${hasErrors(bean: projetpoiss.Image, file: 'associatedFile','errors')}'>
                       <input type="file" name="associatedFile" accept="image/*">
                   </td>
                </tr>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="Sauvegarder" />
                </fieldset>

            </g:form>
        </div>
    </body>
</html>

