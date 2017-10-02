grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain
        [
                pattern: '/api/**',
                filters: 'JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter']
]
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.ttn.geekCombat.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.ttn.geekCombat.UserRole'
grails.plugin.springsecurity.authority.className = 'com.ttn.geekCombat.Role'

grails.plugin.springsecurity.rest.token.storage.useGorm = true
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'com.ttn.geekCombat.AuthenticationToken'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName = 'tokenValue'
grails.plugin.springsecurity.rest.token.storage.gorm.usernamePropertyName = 'username'

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