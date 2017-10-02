package asset.management

import com.ttn.geekCombat.BootstrapService

class BootStrap {
    BootstrapService bootstrapService

    def init = { servletContext ->
        bootstrapService.createUsers()
    }
    def destroy = {
    }
}
