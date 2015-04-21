package bbutils

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RepositoryController {

  def index() {
    def sort = params['sort']
    def order = params['order']
    respond Repository.list(sort: sort, order: order), model:[repositoryCount: Repository.count()]
  }

  def show(Repository repository) {
    respond repository
  }

  protected void notFound() {
    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.not.found.message', args: [message(code: 'repository.label', default: 'Repository'), params.id])
        redirect action: "index", method: "GET"
      }
      '*'{ render status: NOT_FOUND }
    }
  }
}
