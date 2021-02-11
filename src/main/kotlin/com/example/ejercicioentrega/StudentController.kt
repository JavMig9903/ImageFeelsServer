package com.example.ejercicioentrega

import org.springframework.web.bind.annotation.*


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
        return trackRepository.findById(id).get()
    }

    //curl -v localhost:8081/deletetrack/12
    @DeleteMapping("/deletetrack/{id}")
    fun deleteTracks(@PathVariable id:Long){
        trackRepository.deleteById(id)
    }
}