package com.example.testingproject

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.testingproject.helpers.FieldsComparator
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class FieldsComparatorTest {

    private lateinit var fieldsComparator: FieldsComparator

    @Before
    fun setup() {
        fieldsComparator = FieldsComparator()
    }

    @Test
    fun Text_Equals_App_Name_Should_Return_True() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = fieldsComparator.isEqual(context, "TestingProject")
        assertThat(result).isTrue()
    }

    @Test
    fun Text_Equals_Different_Name_Should_Return_False() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = fieldsComparator.isEqual(context, "Different")
        assertThat(result).isFalse()
    }
}