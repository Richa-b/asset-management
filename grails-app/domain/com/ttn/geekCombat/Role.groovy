package com.ttn.geekCombat

import com.google.gson.annotations.Expose

class Role implements Serializable {

    private static final long serialVersionUID = 1

    @Expose
    Long id

    @Expose
    String authority

    static constraints = {
        authority blank: false, unique: true
    }

    static mapping = {
        id column: 'id', type: 'long'
    }

}

