package com.example.ejercicioentrega

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Users")
class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Registro")
    var numero : Long = 0

    @Column(name = "emailUser",unique = true)
    var emailUser:String = ""

    @Column(name = "nameUser")
    var nameUSer:String = ""

    @Column(name = "imageUser")
    var imageUser:String = ""

    constructor(emailUser:String,nameUser:String,imageUser:String){
        this.emailUser=emailUser
        this.nameUSer=nameUser
        this.imageUser=imageUser
    }

    override fun equals(other: Any?): Boolean {
        if (other is Users) {
            return other.nameUSer == nameUSer && nameUSer != null
        }else{
            return false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(emailUser,nameUSer)
    }

    override fun toString(): String {
        return "\nEl usuario $nameUSer está registrado"
    }
}