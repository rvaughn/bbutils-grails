package bbutils

import grails.test.mixin.*
import spock.lang.*

@TestFor(RepositoryController)
@Mock(Repository)
class RepositoryControllerSpec extends Specification {

  void "Test that the index action returns the correct model"() {
    when: "The index action is executed"
      controller.index()
    then: "The model is correct"
      !model.repositoryList
      model.repositoryCount == 0
  }

  void "Test that the show action returns the correct model"() {
    when: "A non-existent instance is requested"
      params.id = 'norepo'
      controller.show()
    then: "A redirect is issued and a flash message is set"
      response.redirectUrl == '/repositories'
      flash.message != null
    
    when: "A valid instance is requested"
      def repository = new Repository(name: 'Repo', slug: 'repo', owner: 'owner', dateCreated: new Date(), lastUpdated: new Date())
      repository.save()
      params.id = 'repo'
      controller.show()
    then: "A model is populated containing the correct instance"
      model.repository == repository
  }

}
