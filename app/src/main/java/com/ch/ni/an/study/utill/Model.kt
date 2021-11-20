package com.ch.ni.an.study.utill


interface Model<S, E>{

    fun getFact()

    fun init(callBack : ResultCallback<S, E> )

    fun clear()
}