package bbutils

import grails.test.mixin.*
import spock.lang.*

@TestFor(MemberGroupController)
@Mock(MemberGroup)
class MemberGroupControllerSpec extends Specification {

  void "Test the index action returns the correct model"() {
    when: "The index action is executed"
      controller.index()
    then: "The model is correct"
       !model.memberGroupList
       model.memberGroupCount == 0
  }

  void "Test that the show action returns the correct model"() {
    when: "The a non-existent instance is requested"
      params.id = 'nogroup'
      controller.show()
    then: "A redirect is issued and a flash message is set"
      response.redirectUrl == '/groups'
      flash.message != null

    when: "A valid instance is requested"
      def memberGroup = new MemberGroup(name: 'Group', slug: 'group')
      memberGroup.save()
      params.id = 'group'
      controller.show()
    then: "A model is populated containing the correct instance"
      model.memberGroup == memberGroup
  }

}
