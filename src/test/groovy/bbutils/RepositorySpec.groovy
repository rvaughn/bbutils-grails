package bbutils

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Repository)
class RepositorySpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  void "test URL generation"() {
    when:
      def repo = new Repository(name: 'Repo', slug: 'bar', owner: 'foo', dateCreated: new Date(), lastUpdated: new Date())

    then:
      repo.url == "https://bitbucket.org/foo/bar"
  }

}
