package com.ch.ni.an.study.test

import com.ch.ni.an.study.utill.Model
import com.ch.ni.an.study.utill.ResultCallback


class TestModel: Model<Any, Any> {

    private var callback: ResultCallback<Any, Any>? = null

    private var count = 1


    override fun getFact() {
        Thread{
            Thread.sleep(1000)
            if (count % 2 == 0) {
                callback?.provideSuccess("success")
            } else {
                callback?.provideError("error")
            }

            count++
        }.start()

    }

    override fun init(callBack :ResultCallback<Any, Any>) {
       this.callback = callBack
    }

    override fun clear() {
        callback = null
    }
}