package bbutils

class Repository {

  static hasMany = [members:MemberPermission, groups:GroupPermission]

  static constraints = {
    desc nullable: true
  }

  static mapping = {
    autoTimestamp false
  }

  String name
  String slug
  String desc
  String owner
  Date dateCreated
  Date lastUpdated
}
