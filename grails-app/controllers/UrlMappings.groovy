class UrlMappings {

  static mappings = {
    "/groups" (resources: 'memberGroup', includes: ['index', 'show'])
    "/repositories" (resources: 'repository', includes: ['index', 'show'])
    "/members" (resources: 'member', includes: ['index', 'show'])

    "/" (controller: 'stats')
    "500" (view:'/error')
    "404" (view:'/notFound')
  }
}
