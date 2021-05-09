package com.example.ejercicioentrega

import org.springframework.web.bind.annotation.*
@RestController
class UsersController(private val repoUsers: UsersRepository) {
    //curl -v localhost:8081/getAllUsers
    @GetMapping("/getAllUsers")
    fun getAllUsers(): List<Users>{
        return repoUsers.findAll()
    }

    //curl -v localhost:8081/instertUsers
    @PostMapping("/instertUsers")
    fun insertUsers(@RequestBody user : Users){
        repoUsers.save(user)
    }

    //curl -v localhost:8081/countTrack
    @GetMapping("/countUsers")
    fun countTracks(): String {
        return "Hay ${repoUsers.count()} tracks"
    }

    //curl -v localhost:8081/givemeuser/12
    @GetMapping("/givemeuser/{id}")
    fun getUser(@PathVariable id:Long) : Users{
        return repoUsers.findById(id).get()
    }

    //curl -v localhost:8081/deleteuser/12
    @DeleteMapping("/deleteuser/{id}")
    fun deleteUsers(@PathVariable id:Long){
        repoUsers.deleteById(id)
    }
}