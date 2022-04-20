package com.felipe.popularTvSeries.mobile.mainView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.felipe.populartvseries.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainPresenter.MainView {

  @Inject lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    presenter.attachView(this)
  }

  override fun showLoading() {
  }

  override fun hideLoading() {
  }
}