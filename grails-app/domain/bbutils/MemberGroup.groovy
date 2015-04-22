package bbutils

class MemberGroup {

  static hasMany = [members:Member, repositories:GroupPermission]

  static constraints = {
    permission nullable: true
  }

  String name
  String slug
  String permission

  String getKey() {
    slug
  }

  static MemberGroup findByKey(String key) {
    findBySlug(key)
  }
}
