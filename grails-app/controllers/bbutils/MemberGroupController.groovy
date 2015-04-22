package bbutils

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MemberGroupController {

  def index() {
    if (params.sort != 'name') {
      params.sort = 'name'
    }
    if (params.order != 'asc' && params.order != 'desc') {
      params.order = 'asc'
    }
    respond MemberGroup.list(params), model:[memberGroupCount: MemberGroup.count()]
  }

  def show() {
    def group = MemberGroup.findByKey(params.id)
    if (group) {
      respond group
    } else {
      flash.message = "Group ${params.id} not found."
      redirect(action: 'index')
    }
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
