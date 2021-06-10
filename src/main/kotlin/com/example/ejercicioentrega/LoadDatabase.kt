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
    fun initDataBase(repoUsers : UsersRepository, repoFollowers : FollowRepository, repoPubli : PublicationsRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            logger.info("Preloading "+repoUsers.save(Users("ejemplo1@gmail.com","ejemplo1@gmail.com".substringBeforeLast('@'),"https://media.hearstapps.com/hmg-prod/images/dragon-ball-super-broly-1548962857.jpg")))
            logger.info("Preloading "+repoUsers.save(Users("ejemplo2@gmail.com","ejemplo2@gmail.com".substringBeforeLast('@'),"https://upload.wikimedia.org/wikipedia/en/4/40/Star_Wars_Phantom_Menace_poster.jpg")))
            logger.info("Preloading "+repoPubli.save(Publications("ejemplo1@gmail.com".substringBeforeLast('@'),"https://media.hearstapps.com/hmg-prod/images/dragon-ball-super-broly-1548962857.jpg","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Carrasco2016.jpg/330px-Carrasco2016.jpg","none")))
            logger.info("Preloading "+repoPubli.save(Publications("ejemplo2@gmail.com".substringBeforeLast('@'),"https://upload.wikimedia.org/wikipedia/en/4/40/Star_Wars_Phantom_Menace_poster.jpg","https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Messi_vs_Nigeria1.jpg/375px-Messi_vs_Nigeria1.jpg","none")))
        }
    }
}