package com.example.mywidget
import java.util.*

import kotlin.random.Random

internal object NumberGenerator {
    fun RandomNumber(max: Int): Int{
        val random = java.util.Random()
        return random.nextInt(max)
    }
}