package projetpoiss

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('isAuthenticated()')
class UserController {

    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
       // User user=sec.loggedInUserInfo(null);
        params.max = Math.min(max ?: 10, 100)
        respond userService.list(params), model:[userCount: userService.count()]
       // if(user.authorities.any{it.authority  == "ROLE_ADMIN"}) {
         //   respond userService.list(params), model: [userCount: userService.count()]
        //}
        //if(user.authorities.any{it.authority == "ROLE_MODERATOR"}) {
          //  respond userService.list(params), model: [userCount: userService.count()]
        //}
    }

    def show(Long id) {
        respond userService.get(id)
        [user: User.get(params.id)]
    }

    def handleLogin = {

    }

    @Secured('permitAll')
    def create() {
        respond new User(params)
    }


    @Secured(value = ["hasRole('ROLE_ADMIN')"])
    def save(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            userService.save(user)

        } catch (ValidationException e) {
            respond user.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userService.get(id)
        [user: User.get(params.id)]
    }

    def update(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
