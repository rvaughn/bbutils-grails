package bbutils

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RepositoryController {

  def index() {
    if (params.sort != 'name' && params.sort != 'lastUpdated') {
      params.sort = 'name'
    }
    if (params.order != 'asc' && params.order != 'desc') {
      params.order = 'asc'
    }
    respond Repository.list(params), model:[repositoryCount: Repository.count()]
  }

  def show() {
    def repo = Repository.findByKey(params.id)
    if (repo) {
      respond repo
    } else {
      flash.message = "Repository ${params.id} not found."
      redirect(action: 'index')
    }
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
