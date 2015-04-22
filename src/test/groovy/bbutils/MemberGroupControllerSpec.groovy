package bbutils

import grails.test.mixin.*
import spock.lang.*

@TestFor(MemberGroupController)
@Mock(MemberGroup)
class MemberGroupControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.memberGroupList
            model.memberGroupCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.memberGroup!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def memberGroup = new MemberGroup()
            memberGroup.validate()
            controller.save(memberGroup)

        then:"The create view is rendered again with the correct model"
            model.memberGroup!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            memberGroup = new MemberGroup(params)

            controller.save(memberGroup)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/memberGroup/show/1'
            controller.flash.message != null
            MemberGroup.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def memberGroup = new MemberGroup(params)
            controller.show(memberGroup)

        then:"A model is populated containing the domain instance"
            model.memberGroup == memberGroup
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def memberGroup = new MemberGroup(params)
            controller.edit(memberGroup)

        then:"A model is populated containing the domain instance"
            model.memberGroup == memberGroup
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/memberGroup/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def memberGroup = new MemberGroup()
            memberGroup.validate()
            controller.update(memberGroup)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.memberGroup == memberGroup

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            memberGroup = new MemberGroup(params).save(flush: true)
            controller.update(memberGroup)

        then:"A redirect is issued to the show action"
            memberGroup != null
            response.redirectedUrl == "/memberGroup/show/$memberGroup.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/memberGroup/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def memberGroup = new MemberGroup(params).save(flush: true)

        then:"It exists"
            MemberGroup.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(memberGroup)

        then:"The instance is deleted"
            MemberGroup.count() == 0
            response.redirectedUrl == '/memberGroup/index'
            flash.message != null
    }
}
