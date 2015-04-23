package bbutils

import grails.test.mixin.*
import spock.lang.*

@TestFor(MemberController)
@Mock(Member)
class MemberControllerSpec extends Specification {

  void "Test that the index action returns the correct model"() {
    when: "The index action is executed"
      controller.index()
    then: "The model is correct"
      !model.memberList
      model.memberCount == 0
  }

  void "Test that the show action returns the correct model"() {
    when: "A non-existent instance is requested"
      params.id = 'nobody'
      controller.show()
    then: "A redirect is issued and a flash message is set"
      response.redirectUrl == '/members'
      flash.message != null
    
    when: "A valid instance is requested"
      def member = new Member(name: 'Some Name', username: 'somename')
      member.save()
      params.id = 'somename'
      controller.show()
    then: "A model is populated containing the correct instance"
      model.member == member
  }

}
