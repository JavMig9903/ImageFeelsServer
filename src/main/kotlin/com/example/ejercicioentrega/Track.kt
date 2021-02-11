package com.example.ejercicioentrega

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Track (var name: String, var collectionName : String, var artistName : String){
    @Id
    @GeneratedValue
    private val id: Long? = null

    override fun equals(other: Any?): Boolean {
        if (other is Track) {
            return other.artistName == artistName && artistName != null
        }else{
            return false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(name,collectionName,artistName)
    }

    override fun toString(): String {
        return "\nEl track de $artistName está subido"
    }
}