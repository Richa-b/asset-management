package asset.management

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')

        "/api/util/test"(controller: "util") {
            action = [POST: "test"]
        }
    }
}
