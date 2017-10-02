grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain
        [
                pattern: '/api/**',
                filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ],

        //Traditional chain
        [
                pattern: '/**',
                filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
        ]
]


//rest configuration
grails.plugin.springsecurity.rest.token.storage.useGorm = true // since using gorm for token storage
grails.plugin.springsecurity.rest.token.generation.useSecureRandom = true
grails.plugin.springsecurity.rest.login.active =true
grails.plugin.springsecurity.rest.login.useJsonCredentials = true // can use json a request parameter
grails.plugin.springsecurity.rest.login.usernamePropertyName = 'username' // field of username parameter
grails.plugin.springsecurity.rest.login.passwordPropertyName = 'password' // field of pasword parameter
grails.plugin.springsecurity.rest.login.useRequestParamsCredential = true

grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'com.ttn.geekCombat.AuthenticationToken'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName = 'tokenValue'
grails.plugin.springsecurity.rest.token.storage.gorm.usernamePropertyName = 'username'

grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'
grails.plugin.springsecurity.rest.login.endpointUrl = '/api/login'
grails.plugin.springsecurity.rest.login.failureStatusCode = 401
//token validate
grails.plugin.springsecurity.rest.token.validation.useBearerToken = true
grails.plugin.springsecurity.rest.token.validation.active=true
grails.plugin.springsecurity.rest.token.validation.endpointUrl='/api/validate'
//end of rest configuration



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