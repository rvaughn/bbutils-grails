package bbutils

class MemberPermission {

  static belongsTo = [member:Member, repository:Repository]
  
  static constraints = {
  }

  String permission
}
