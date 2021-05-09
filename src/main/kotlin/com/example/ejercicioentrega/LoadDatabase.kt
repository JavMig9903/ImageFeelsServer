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
    fun initDataBase(repoUsers : UsersRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            logger.info("Preloading "+repoUsers.save(Users("ejemplo1@gmail.com","ejemplo1@gmail.com".substringBeforeLast('@'))))
            logger.info("Preloading "+repoUsers.save(Users("ejemplo2@gmail.com","ejemplo2@gmail.com".substringBeforeLast('@'))))
        }
    }
}