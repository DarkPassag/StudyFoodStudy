package com.ch.ni.an.study

import android.app.Application
import com.ch.ni.an.study.test.TestModel

class FoodApp: Application() {

    lateinit var viewModel :ViewModel

    override fun onCreate() {
        super.onCreate()

        viewModel = ViewModel(TestModel())

    }
}