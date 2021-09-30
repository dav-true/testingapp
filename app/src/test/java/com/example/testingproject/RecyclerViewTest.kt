package com.example.testingproject

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.testingproject.adapters.RecyclerViewAdapter
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class RecyclerViewTest {

    @Inject lateinit var recyclerViewAdapter: RecyclerViewAdapter

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun test() {
        val list = listOf(Result(1,"H"))

        //GIVEN
        recyclerViewAdapter.setResults(list)
        given(recyclerViewAdapter.itemCount).willReturn(1)

        //WHEN
        val count = recyclerViewAdapter.itemCount

        //THEN
        assertEquals(count, list.size)
    }
}