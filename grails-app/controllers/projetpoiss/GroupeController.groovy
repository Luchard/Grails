package projetpoiss

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('isAuthenticated()')
class GroupeController {

    GroupeService groupeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond groupeService.list(params), model:[groupeCount: groupeService.count()]
    }

    def show(Long id) {
        respond groupeService.get(id)
        [groupe: Groupe.get(params.id)]
    }

    def create() {
        respond new Groupe(params)
    }

    def save(Groupe groupe) {
        if (groupe == null) {
            notFound()
            return
        }

        try {
            groupeService.save(groupe)
        } catch (ValidationException e) {
            respond groupe.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'groupe.label', default: 'Groupe'), groupe.id])
                redirect groupe
            }
            '*' { respond groupe, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond groupeService.get(id)
        [groupe: Groupe.get(params.id)]
    }

    def update(Groupe groupe) {
        if (groupe == null) {
            notFound()
            return
        }

        try {
            groupeService.save(groupe)
        } catch (ValidationException e) {
            respond groupe.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'groupe.label', default: 'Groupe'), groupe.id])
                redirect groupe
            }
            '*'{ respond groupe, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        groupeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'groupe.label', default: 'Groupe'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'groupe.label', default: 'Groupe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
