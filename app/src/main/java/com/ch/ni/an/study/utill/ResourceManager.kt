package com.ch.ni.an.study.utill

import android.content.Context
import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringResId: Int) : String
}

class BaseResourceManager(private val contex: Context): ResourceManager {

    override fun getString(stringResId :Int) = contex.getString(stringResId)

}