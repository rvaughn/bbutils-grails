import bbutils.*
import grails.util.GrailsUtil
import java.text.SimpleDateFormat

class BootStrap {

  def init = { servletContext ->
    if (GrailsUtil.isDevelopmentEnv()) {
      println "bootstrapping dev environment..."
      def dates = new SimpleDateFormat("yyyy-MM-dd")
      def repo1 = new Repository(
        name: "Repo1",
        slug: "repo1",
        owner: "foobar",
        dateCreated: dates.parse("2013-12-16"),
        lastUpdated: dates.parse("2014-05-16"))
      def repo2 = new Repository(
        name: "Repo2",
        slug: "repo2",
        owner: "foobar",
        dateCreated: dates.parse("2014-05-21"),
        lastUpdated: dates.parse("2014-05-22"))
      def rrr = new Repository(
        name: "Repo Repo Repo",
        slug: "repo-repo-repo",
        owner: "foobar",
        dateCreated: dates.parse("2014-01-04"),
        lastUpdated: dates.parse("2015-02-01"))
      def rgw = new Repository(
        name: "Repos Gone Wild",
        slug: "repos-gone-wild",
        owner: "foobar",
        dateCreated: dates.parse("2015-01-12"),
        lastUpdated: dates.parse("2015-03-21"))
      
      def sam = new Member(name: "Sam Smith", username: "samsmith")
      def jane = new Member(name: "Jane Doe", username: "janedoe")
      def john = new Member(name: "John Doe", username: "johndoe")

      def devs = new MemberGroup(name: "Developers", slug: "developers")
      def admins = new MemberGroup(name: "Admins", slug: "admins")

      devs.addToMembers(sam)
      devs.addToMembers(jane)
      devs.addToMembers(john)

      admins.addToMembers(sam)

      repo1.save()
      repo2.save()
      rrr.save()
      rgw.save()

      sam.save()
      jane.save()
      john.save()

      devs.save()
      admins.save()
      
      new GroupPermission(permission: "write", group: devs, repository: repo1).save()
      new GroupPermission(permission: "write", group: devs, repository: repo2).save()
      new GroupPermission(permission: "read", group: devs, repository: rrr).save()
      new GroupPermission(permission: "admin", group: admins, repository: repo1).save()
      new GroupPermission(permission: "admin", group: admins, repository: repo2).save()
      new GroupPermission(permission: "admin", group: admins, repository: rrr).save()
      new GroupPermission(permission: "admin", group: admins, repository: rgw).save()

      new MemberPermission(permission: "read", member: jane, repository: rgw).save()
      new MemberPermission(permission: "write", member: john, repository: rgw).save()
      new MemberPermission(permission: "admin", member: jane, repository: rrr).save()
    }
  }
  
  def destroy = {
  }
  
}
