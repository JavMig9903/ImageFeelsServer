package com.example.ejercicioentrega

import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<Users,Long>
interface FollowRepository: JpaRepository<Follow,Long>
interface PublicationsRepository: JpaRepository<Publications,Long>