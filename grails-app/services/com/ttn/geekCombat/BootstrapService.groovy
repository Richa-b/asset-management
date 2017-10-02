package com.ttn.geekCombat

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional

@Transactional
class BootstrapService {

    SpringSecurityService springSecurityService

    def createUsers() {
        if(!User.count){
            User user = new User(username: 'deepak.kalra@tothenew.com',password: springSecurityService.encodePassword('igdefault')).save(failOnError : true)
            Role role = new Role(authority: 'ROLE_ADMIN').save(failOnError : true)
            UserRole userRole = new UserRole(user: user,role: role).save(failOnError : true)
        }
    }
}
