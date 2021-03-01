package com.example.ejercicioentrega

import org.springframework.web.bind.annotation.*
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

import java.security.MessageDigest
import javax.crypto.BadPaddingException


private fun cifrar(textoEnString : String, llaveEnString : String) : String {
    println("Voy a cifrar $textoEnString")
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, getKey(llaveEnString))
    val textCifrado = Base64.getEncoder().encodeToString(cipher.doFinal(textoEnString.toByteArray(Charsets.UTF_8)))
    println("He obtenido $textCifrado")
    return textCifrado
}
@Throws(BadPaddingException::class)
private fun descifrar(textoCifrrado : String, llaveEnString : String) : String {
    println("Voy a descifrar $textoCifrrado")
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, getKey(llaveEnString));
    val textDescifrado = String(cipher.doFinal(Base64.getDecoder().decode(textoCifrrado)))
    println("He obtenido $textDescifrado")
    return textDescifrado
}


private fun getKey(llaveEnString : String): SecretKeySpec {
    var llaveUtf8 = llaveEnString.toByteArray(Charsets.UTF_8)
    val sha = MessageDigest.getInstance("SHA-1")
    llaveUtf8 = sha.digest(llaveUtf8)
    llaveUtf8 = llaveUtf8.copyOf(16)
    return SecretKeySpec(llaveUtf8, "AES")
}

@RestController
class StudentController(private val trackRepository: TrackRepository) {


    //curl -v localhost:8081/getAllTracks
    @GetMapping("/getAllTracks")
    fun getAllTracks(): List<Track>{
        return trackRepository.findAll()
    }

    //curl -v localhost:8081/instertrack
    @PostMapping("/instertrack")
    fun insertTrack(@RequestBody track : Track){
        trackRepository.save(track)
    }

    //curl -v localhost:8081/countTrack
    @GetMapping("/countTrack")
    fun countTracks(): String {
        return "Hay ${trackRepository.count()} tracks"
    }

    //curl -v localhost:8081/givemetrack/12
    @GetMapping("/givemetrack/{id}")
    fun getTracks(@PathVariable id:Long) : Track{
        val cifrar= id.toString();
        val key="FUAA"
        val descifrada=descifrar(cifrar(cifrar,key),key)
        return trackRepository.findById(descifrada.toLong()).get()
    }

    //curl -v localhost:8081/deletetrack/12
    @DeleteMapping("/deletetrack/{id}")
    fun deleteTracks(@PathVariable id:Long){
        trackRepository.deleteById(id)
    }
}