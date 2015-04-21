package bbutils

class Member {

  static hasMany = [groups:MemberGroup, repositories:MemberPermission]
  static belongsTo = MemberGroup
  
  static constraints = {
  }

  String name
  String username
}
