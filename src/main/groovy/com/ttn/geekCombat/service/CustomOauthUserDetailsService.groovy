package com.ttn.geekCombat.service

import com.ttn.geekCombat.Role
import com.ttn.geekCombat.UserRole
import grails.plugin.springsecurity.rest.oauth.OauthUser
import grails.plugin.springsecurity.rest.oauth.OauthUserDetailsService
import groovy.util.logging.Slf4j
import org.pac4j.core.profile.CommonProfile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsChecker
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

/**
 * Created by deepak on 2/10/17.
 */
@Slf4j
class CustomOauthUserDetailsService implements OauthUserDetailsService {

    @Autowired
    UserDetailsService userDetailsService

    UserDetailsChecker preAuthenticationChecks

    @Override
    OauthUser loadUserByUserProfile(CommonProfile userProfile, Collection<GrantedAuthority> defaultRoles) throws UsernameNotFoundException {
        UserDetails userDetails

        OauthUser oauthUser

        try {
            log.debug "Trying to fetch user details for user profile: ${userProfile}"
            userDetails = userDetailsService.loadUserByUsername userProfile.email

            Collection<GrantedAuthority> allRoles = userDetails.authorities + defaultRoles
            oauthUser = new OauthUser(userDetails.username, userDetails.password, allRoles, userProfile)
        } catch (UsernameNotFoundException unfe) {
          throw unfe
        }

        return oauthUser
    }

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null
    }
}
