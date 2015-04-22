package bbutils

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MemberGroupController {

    def index() {
        respond MemberGroup.list(params), model:[memberGroupCount: MemberGroup.count()]
    }

    def show(MemberGroup memberGroup) {
        respond memberGroup
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'memberGroup.label', default: 'MemberGroup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
