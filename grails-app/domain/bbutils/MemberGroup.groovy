package bbutils

class MemberGroup {

  static hasMany = [members:Member, repositories:GroupPermission]

  static constraints = {
    permission nullable: true
  }

  String name
  String slug
  String permission
}
