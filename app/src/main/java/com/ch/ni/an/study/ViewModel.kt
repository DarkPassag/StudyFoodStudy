package com.ch.ni.an.study

import com.ch.ni.an.study.model.FoodData
import com.ch.ni.an.study.utill.FoodFailure
import com.ch.ni.an.study.utill.Model
import com.ch.ni.an.study.utill.ResultCallback
import com.ch.ni.an.study.utill.TextCallBack


class ViewModel(private val model:Model<FoodData, FoodFailure>) {

    private var callback: TextCallBack? = null

    fun init(callBack :TextCallBack){
        this.callback = callBack
        model.init(object : ResultCallback<FoodData, FoodFailure> {


            override fun provideSuccess(data :FoodData) = callBack.provideText(data.toString())

            override fun provideError(error :FoodFailure) = callBack.provideText(error.getMessage())

        })

    }

    fun getFact(){
        model.getFact()
    }

    fun clear(){
        callback = null
        model.clear()
    }
}

