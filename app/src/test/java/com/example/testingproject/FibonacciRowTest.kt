package com.example.testingproject

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FibonacciRowTest {

    @Test
    fun `Check fibonacci function`() {
        val result = FibonacciRow.createRow(11)
        assertThat(result).isEqualTo(listOf(0,1,1,2,3,5,8,13,21,34,55))
    }

    @Test
    fun `Count = 0`() {
        val result = FibonacciRow.createRow(0)
        assertThat(result).isEqualTo(emptyList<Int>())
    }
}