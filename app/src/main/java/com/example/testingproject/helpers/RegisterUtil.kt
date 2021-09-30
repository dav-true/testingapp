package com.example.testingproject.helpers

object RegisterUtil {

    private val alreadyRegisteredUsers = listOf("Daniel", "Gregor")

    fun register(
        name: String,
        surname: String,
        password: String
    ): Boolean {
        return !(name.isEmpty()
                || surname.isEmpty()
                || password.length < 6
                || name in alreadyRegisteredUsers)
    }





}