package com.ch.ni.an.study.utill

import com.ch.ni.an.study.R

interface FoodFailure{
    fun getMessage(): String
}

class NoConnection(private val resourceManager :BaseResourceManager) : FoodFailure{
    override fun getMessage() = resourceManager.getString(R.string.no_connection)
}

class ServiceUnavailable(private val resourceManager :BaseResourceManager): FoodFailure{
    override fun getMessage() = resourceManager.getString(R.string.service_unavailable)

}