package com.example.ejercicioentrega

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoadDatabase {
    companion object {
        val logger = LoggerFactory.getLogger(LoadDatabase.javaClass)
    }

    @Bean
    fun initDataBase(trackRepositorio : TrackRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            logger.info("Preloading "+trackRepositorio.save(Track("Weird Fishes / Arpeggi","Rainbows","Radiohead")))
            logger.info("Preloading "+trackRepositorio.save(Track("Reckoner","Rainbows","Radiohead")))
            logger.info("Preloading "+trackRepositorio.save(Track("Faust Arp","Rainbows","Radiohead")))
            logger.info("Preloading "+trackRepositorio.save(Track("House of cards","Rainbows","Radiohead")))
            logger.info("Preloading "+trackRepositorio.save(Track("Nude","Rainbows","Radiohead")))

            logger.info("Preloading "+trackRepositorio.save(Track("Lip Gloss","Martes 13","Natos y Waor")))
            logger.info("Preloading "+trackRepositorio.save(Track("Carretera","Hijos de la Ruina Vol. 2","Natos y Waor")))
            logger.info("Preloading "+trackRepositorio.save(Track("Problemas","Martes 13","Natos y Waor")))
            logger.info("Preloading "+trackRepositorio.save(Track("Camarón","Martes 13","Natos y Waor")))
            logger.info("Preloading "+trackRepositorio.save(Track("Piratas","Cicatrices","Natos y Waor")))

            logger.info("Preloading "+trackRepositorio.save(Track("La placita","La placita - Single","Delaossa")))
            logger.info("Preloading "+trackRepositorio.save(Track("Si me quieren matar","Salí del barrio - Single","Delaossa")))
            logger.info("Preloading "+trackRepositorio.save(Track("Marte","Marte - Single","Delaossa")))
            logger.info("Preloading "+trackRepositorio.save(Track("Lejos","Lejos - Single","Delaossa")))
            logger.info("Preloading "+trackRepositorio.save(Track("Dicen mi","Perro Andaluz","Delaossa")))
        }
    }
}