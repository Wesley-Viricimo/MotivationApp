package com.example.motivationapp.util

class MotivationConstants private constructor() { //Private constructor indica que nenhuma classe poderá instânciá-la
    object KEY {
        const val USER_NAME = "USER_NAME"
    }

    object FILTER {
        const val ALL = 1
        const val HAPPY = 2
        const val SUNNY = 3
    }
}