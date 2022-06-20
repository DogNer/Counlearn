package com.example.counlearn.Modals

class User {
    var name: String? = null
    var email: String? = null
    var password: String? = null
    var uid: String? = null
    var continent: String? =  null

    constructor(){}

    constructor(name: String?, email: String?, password: String?, uid: String?, continent : String?){
        this.name = name
        this.email = email
        this.password = password
        this.uid = uid
        this.continent = continent
    }
}