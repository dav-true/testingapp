package com.example.testingproject

import android.content.Context

class CompareFields {
    fun isEqual(context: Context, text: String) =
        context.getString(R.string.app_name) == text
}