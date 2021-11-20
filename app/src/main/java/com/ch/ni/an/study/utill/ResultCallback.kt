package com.ch.ni.an.study.utill



interface ResultCallback<S, E>{

    fun provideSuccess(data:S)

    fun provideError(error:E)
}