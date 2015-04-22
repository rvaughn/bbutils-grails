package bbutils

class StatsController {

  def index() {
    [repositories: [count: Repository.count()], members: [count: Member.count()], groups: [count: MemberGroup.count()]]
  }

}
