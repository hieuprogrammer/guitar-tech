package io.hieu.guitartech

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GuitarTechApplication

fun main(args: Array<String>) {
    runApplication<GuitarTechApplication>(*args)
}