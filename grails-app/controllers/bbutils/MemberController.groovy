package bbutils

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MemberController {

  def index() {
    if (params.sort != 'name' && params.sort != 'username') {
      params.sort = 'name'
    }
    if (params.order != 'asc' && params.order != 'desc') {
      params.order = 'asc'
    }
    respond Member.list(params), model:[memberCount: Member.count()]
  }

  def show() {
    def member = Member.findByKey(params.id)
    if (member) {
      respond member
    } else {
      flash.message = "Member ${params.id} not found."
      redirect(action: 'index')
    }
  }

  protected void notFound() {
    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.not.found.message', args: [message(code: 'member.label', default: 'Member'), params.id])
        redirect action: "index", method: "GET"
      }
      '*'{ render status: NOT_FOUND }
    }
  }
}
