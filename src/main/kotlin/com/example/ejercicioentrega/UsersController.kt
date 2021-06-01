package com.example.ejercicioentrega

import org.springframework.web.bind.annotation.*

@RestController
class UsersController(private val repoUsers: UsersRepository, private val repoFoll: FollowRepository, private val repoPubli: PublicationsRepository) {

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

    //curl -v localhost:8081/getPublicUser/ejemplo1
    @GetMapping("/getPublicUser/{nomUser}")
    fun getPublicUser(@PathVariable nomUser:String): List<Publications>{
        val porf: MutableList<Publications> = repoPubli.findAll()
        var final:MutableList<Publications> = TODO()
        var id:Long=0
        var cont=0
        porf.forEach {
            if (it.nameUsu==nomUser){
                id=it.numero
                final.add(cont,it)
                cont++
            }
        }
        var listafinal: List<Publications> = final
        return listafinal
    }
    //curl -v localhost:8081/givemeuser?nameUser=ejemplo1
    //http://localhost:8081/givemeuser?nameUser=ejemplo1
    @GetMapping("/givemeuser")
    fun getUser(@RequestParam("nameUser",defaultValue = "Nose")nombre:String) : Users{
        val ej: MutableList<Users> = repoUsers.findAll()
        var id:Long=0
        ej.forEach {
            if (it.nameUSer==nombre){
                id=it.numero
                return@forEach
            }
        }
        return repoUsers.findById(id).get()
    }



    @GetMapping("/givemeuser/{id}")
    fun getUser(@PathVariable id:Long) : Users{
        return repoUsers.findById(id).get()
    }

    //curl -v localhost:8081/insertUser/ejemplo@gmail.com/https:@@ceslava.s3-accelerate.amazonaws.com@2016@04@mistery-man-gravatar-wordpress-avatar-persona-misteriosa-510x510.png
    @GetMapping("/insertUser/{idUser}/{imgUser}")
    fun insertUser(@PathVariable idUser:String,@PathVariable imgUser:String){
        var auxiliar:String=imgUser.replace("@","/")
        print(auxiliar)
        repoUsers.save(Users(idUser,idUser.substringBeforeLast('@'),auxiliar))
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