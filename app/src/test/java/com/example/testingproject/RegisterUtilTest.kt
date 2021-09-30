package com.example.testingproject

import com.example.testingproject.helpers.RegisterUtil
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegisterUtilTest {

    @Test
    fun `User name is empty`() {
        val result = RegisterUtil.register("", "Savoliuk", "1111")
        assertThat(result).isFalse()
    }

    @Test
    fun `Surname is empty`() {
        val result = RegisterUtil.register("Danil", "", "1111")
        assertThat(result).isFalse()
    }

    @Test
    fun `Password length is less than 6`() {
        val result = RegisterUtil.register("Danil", "Surname", "")
        assertThat(result).isFalse()
    }

    @Test
    fun `User already registered`() {
        val result = RegisterUtil.register("Daniel", "Surname", "111111")
        assertThat(result).isFalse()
    }

    @Test
    fun `All parameters correct `() {
        val result = RegisterUtil.register("Danil", "Surname", "111111")
        assertThat(result).isTrue()
    }
}