package com.example.ejercicioentrega

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.awt.Image
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

@RestController
class UsersController(private val repoUsers: UsersRepository, private val repoPubli: PublicationsRepository) {

    //curl -v localhost:8081/getAllUsers
    @GetMapping("/getAllUsers")
    fun getAllUsers(): List<Users>{
        return repoUsers.findAll()
    }

    //curl -v localhost:8081/getAllPubli
    @GetMapping("/getAllPubli")
    fun getAllPubli(): List<Publications>{
        return repoPubli.findAll()
    }


    //curl -v localhost:8081/givemeuser?nameUser=ejemplo1
    //http://localhost:8081/givemeuser?nameUser=ejemplo1
    @GetMapping("/editUser/{nombreantes}/{nombreuser}/{photouser}")
    fun editUser(@PathVariable nombreantes:String,@PathVariable nombreuser:String,@PathVariable photouser:String){
        val ej: MutableList<Users> = repoUsers.findAll()
        var listafin= ej.filter {
            it.nameUSer.contentEquals(nombreantes)
        }
        repoUsers.deleteById(listafin[0].numero)
        repoUsers.save(Users(listafin[0].emailUser,nombreuser,photouser.replace("@1903","/")))



        var ejemplo:MutableList<Publications> = repoPubli.findAll()
        var listapublic= ejemplo.filter {
            it.nameUsu.contentEquals(nombreantes)
        }
        listapublic.forEach {
            var elemento = it
            repoPubli.deleteById(elemento.numero)
            var auxiliar= photouser.replace("@1903","/")
            repoPubli.save(Publications(nombreuser,auxiliar,elemento.ImgUrl,elemento.numero))
        }
    }



    @GetMapping("/givemeuser/{id}")
    fun getUser(@PathVariable id:Long) : Users{
        return repoUsers.findById(id).get()
    }

    //curl -v localhost:8081/insertUser/hdudvd/https:@@ceslava.s3-accelerate.amazonaws.com@2016@04@mistery-man-gravatar-wordpress-avatar-persona-misteriosa-510x510.png
    @GetMapping("/insertPublic/{idUser}/{body}")
    fun insertPublic(@PathVariable idUser:String,@PathVariable body:String){//(name = "file",required = false) imgSubir:MultipartFile){
        var usu:List<Users> =repoUsers.findAll()
        var lista = usu.filter {
            it.nameUSer.contentEquals(idUser)
        }
        var bodyfin = body.replace("@1903","/")
        repoPubli.save(Publications(lista[0].nameUSer,lista[0].imageUser,bodyfin))
        /**
        var byteArray: ByteArray? = Base64.getDecoder().decode(imgSubir)
        //repoPubli.save(Publications(lista[0].nameUSer,lista[0].imageUser,))
        if (!imgSubir.isEmpty()){
            var ruta:Path= Paths.get(".//src//main//kotlin//Fotos")
            var strRuta:String = ruta.toFile().absolutePath
            var rutaCompleta:Path = Paths.get(strRuta+"//FotoPrueba")
            //sFiles.write(rutaCompleta,imgSubir)
            repoPubli.save(Publications(lista[0].nameUSer,lista[0].imageUser,rutaCompleta.toString()))
        }*/
    }

    @GetMapping("/insertUser/{idUser}/{imgUser}")
    fun insertUser(@PathVariable idUser:String,@PathVariable imgUser:String){
        var auxiliar:String=imgUser.replace("@1903","/")
        repoUsers.save(Users(idUser,idUser.substringBeforeLast('@'),auxiliar))
    }

    //curl -v localhost:8081/getPublicUser/ejemplo1
    @GetMapping("/getPublicUser/{nomUser}")
    fun getPublicUser(@PathVariable nomUser:String): List<Publications>{
        var ejemplo:MutableList<Publications> = repoPubli.findAll()
        var listafin= ejemplo.filter {
            it.nameUsu.contentEquals(nomUser)
        }
    return listafin
    }

    //curl -v localhost:8081/countTrack
    @GetMapping("/countUsers")
    fun countTracks(): String {
        return "Hay ${repoUsers.count()} tracks"
    }


    //curl -v localhost:8081/deleteuser/12
    @DeleteMapping("/deleteuser/{id}")
    fun deleteUsers(@PathVariable id:Long){
        repoUsers.deleteById(id)
    }
}