package com.example.ejercicioentrega

import javax.persistence.*

@Entity
@Table(name = "Followers")
class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Registro")
    var numero : Long = 0

    @Column(name = "IdUsu")
    var IdUsu:String = ""

    @Column(name = "Follow")
    var follow:String = ""

    constructor(IdUsu:String,follow:String){
        this.IdUsu=IdUsu
        this.follow=follow
    }

    override fun toString(): String {
        return "\nEl usuario $IdUsu sigue al usuario $follow"
    }

}