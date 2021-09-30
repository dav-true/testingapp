package com.example.testingproject.helpers


object FibonacciRow {
    fun createRow(count: Int): List<Int> {
        when {
            count > 1 -> {
                val fibonacciNumbers = mutableListOf(0, 1)

                repeat(count - 2) {
                    val num =
                        fibonacciNumbers.last() + fibonacciNumbers.get(fibonacciNumbers.lastIndex - 1)
                    fibonacciNumbers.add(num)
                }
                return fibonacciNumbers
            }
            count == 1 -> {
                return listOf(0)
            }
            else -> {
                return emptyList()
            }
        }
    }
}