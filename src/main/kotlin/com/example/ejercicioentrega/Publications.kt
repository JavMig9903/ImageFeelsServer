package com.example.ejercicioentrega

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Publications")
class Publications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Registro")
    var numero:Long = 0

    @Column(name = "nameUsu")
    var nameUsu:String = ""

    @Column(name = "ImgPerf")
    var ImgPerf:String = ""

    @Column(name = "ImgUrl")
    var ImgUrl:String = ""

    @Column(name = "Img64Base",length = 999999999)
    var Img64Base:String = ""

    constructor(nameUsu:String,ImgPerf:String,ImgUrl:String,Img64Base:String){
        this.nameUsu=nameUsu
        this.ImgPerf=ImgPerf
        this.ImgUrl=ImgUrl
        this.Img64Base=Img64Base
    }

    override fun equals(other: Any?): Boolean {
        if (other is Publications) {
            return other.nameUsu == nameUsu && nameUsu != null
        }else{
            return false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(ImgPerf,nameUsu)
    }

    override fun toString(): String {
        return "\nEl usuario $nameUsu ha subido la foto $Img64Base"
    }

}