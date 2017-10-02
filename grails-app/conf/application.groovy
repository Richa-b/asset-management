grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain
        [pattern: '/api/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],

        //Traditional chain
        //[ pattern: '/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
]

grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.ttn.geekCombat.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.ttn.geekCombat.UserRole'
grails.plugin.springsecurity.authority.className = 'com.ttn.geekCombat.Role'

grails.plugin.springsecurity.rest.token.storage.useGorm = true
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'com.ttn.geekCombat.AuthenticationToken'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName = 'tokenValue'
grails.plugin.springsecurity.rest.token.storage.gorm.usernamePropertyName = 'username'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/api/**', access: ['ROLE_USER']]
]


grails {
    plugin {
        springsecurity {

            rest {

                oauth {

                    frontendCallbackUrl = { String tokenValue -> "http://my.frontend-app.com/welcome#token=${tokenValue}" }

                    google {

                        client = org.pac4j.oauth.client.Google2Client
                        key = '315680507055-5uqcijfb98u0i4pncbilrnc01l9mv7tn.apps.googleusercontent.com'
                        secret = 'zl9IzHEOz6lAz1PQ62Nx3Z9y'
                        scope = org.pac4j.oauth.client.Google2Client.Google2Scope.EMAIL_AND_PROFILE
                        defaultRoles = ['ROLE_USER']

                    }
                }
            }
        }
    }
}

grails.plugin.springsecurity.roleHierarchy = '''
        ROLE_ADMIN > ROLE_USER
'''