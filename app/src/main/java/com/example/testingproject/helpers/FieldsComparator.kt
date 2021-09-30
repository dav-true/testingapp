package com.example.testingproject.helpers

import android.content.Context
import com.example.testingproject.R

class FieldsComparator {
    fun isEqual(context: Context, text: String) =
        context.getString(R.string.app_name) == text
}