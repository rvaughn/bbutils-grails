package bbutils

class GroupPermission {

  static belongsTo = [group:MemberGroup, repository:Repository]

  static constraints = {
  }

  String permission
}
