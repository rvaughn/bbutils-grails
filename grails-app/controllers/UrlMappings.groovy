class UrlMappings {

  static mappings = {
    // REST-style
    "/groups" (resources: 'memberGroup', includes: ['index', 'show'])
    "/repositories" (resources: 'repository', includes: ['index', 'show'])
    "/members" (resources: 'member', includes: ['index', 'show'])

    // default
    "/$controller/$action?/$id?(.$format)?" {
      constraints {
        // apply constraints here
      }
    }

    "/" (view:"/index")
    "500" (view:'/error')
    "404" (view:'/notFound')
  }
}
