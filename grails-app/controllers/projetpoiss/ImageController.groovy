package projetpoiss

import grails.validation.ValidationException
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile

import static org.springframework.http.HttpStatus.*

class ImageController {

    ImageService imageService
    Image imgSrc

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    //static allowedActions = ['show','index','list','create','save' , 'login','validate','edit','viewImage']
    public ImageController ( ) { }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond imageService.list(params), model:[imageCount: imageService.count()]
    }

    def show(Long id) {

        respond imageService.get(id)
        [image: Image.get(params.id)]
    }

    def create() {
        respond new Image(params)
    }

def displayGraph = {
    imgSrc = imageService.get(id)
    render(file:imgSrc.associatedFile,contentType: 'image/png')
}
    def viewImage = {
        def photo = Image.get(params.id)
        response.contentType = "image/jpeg"
        response.outputStream.write(photo?.associatedFile)
    }

    def save(Image image) {
        if (image == null) {
            notFound()
            return
        }

        try {
            if(request instanceof MultipartHttpServletRequest){
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
                CommonsMultipartFile file = (CommonsMultipartFile)multiRequest.getFile("associatedFile");

                image.fileName = file.originalFilename
                image.contentType = file.contentType
               image.associatedFile = file.bytes
                imageService.save(image)
            }

        } catch (ValidationException e) {
            respond image.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'image.label', default: 'Image'), image.id])
                redirect image
            }
            '*' { respond image, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond imageService.get(id)
        [image: Image.get(params.id)]
    }

    def update(Image image) {
        if (image == null) {
            notFound()
            return
        }

        try {
            imageService.save(image)
        } catch (ValidationException e) {
            respond image.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'image.label', default: 'Image'), image.id])
                redirect image
            }
            '*'{ respond image, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        imageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'image.label', default: 'Image'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'image.label', default: 'Image'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
