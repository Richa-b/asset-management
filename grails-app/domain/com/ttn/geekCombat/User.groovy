package com.ttn.geekCombat

class User implements Serializable{
    private static final long serialVersionUID = 1

    transient springSecurityService

    Long id
    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        UserRole.findAllByUserAndIsActive(this,true)*.role
    }

    def beforeInsert() {
        if (password)
            encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static transients = ['springSecurityService']

    static constraints = {
        username unique: true,validator:{ val,obj,errors ->
            if (val.split("@").last() != 'tothenew.com')  errors.rejectValue('username', 'only tothenew usernames allowed')
        }
        password password: true
    }

    static mapping = {
        password column: '`password`'
        id column: 'id', type: 'long'
    }
}
