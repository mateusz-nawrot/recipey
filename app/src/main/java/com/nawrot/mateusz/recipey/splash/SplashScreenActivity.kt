package com.nawrot.mateusz.recipey.splash

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.jakewharton.rxbinding2.view.RxView
import com.nawrot.mateusz.recipey.R
import com.nawrot.mateusz.recipey.base.BaseActivity
import dagger.android.AndroidInjection
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_splash_screen.*
import javax.inject.Inject


class SplashScreenActivity : BaseActivity() {

    @Inject
    lateinit var splashScreenViewModelFactory: SplashScreenViewModelFactory

    private lateinit var splashScreenViewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        splashScreenViewModel = ViewModelProviders.of(this, splashScreenViewModelFactory).get(SplashScreenViewModel::class.java)

        RxView.clicks(splashScreenNavigateButton)
                .subscribeBy(onNext = {
                    splashScreenViewModel.openHomeScreen()
                })
    }

}