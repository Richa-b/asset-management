package com.ttn.geekCombat

import com.google.gson.annotations.Expose
import org.apache.commons.lang.builder.HashCodeBuilder

class UserRole {
    private static final long serialVersionUID = 1

    User user
    @Expose
    Role role

    Boolean isActive = true

    @Override
    boolean equals(other) {
        if (other instanceof UserRole) {
            other.userId == user?.id && other.roleId == role?.id
        }
    }

    @Override
    int hashCode() {
        def builder = new HashCodeBuilder()
        if (user) builder.append(user.id)
        if (role) builder.append(role.id)
        builder.toHashCode()
    }
}
