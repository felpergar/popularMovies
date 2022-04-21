package com.felipe.popularTvSeries.mobile.mainView

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.felipe.popularTvSeries.mobile.common.BaseActivity
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity
import com.felipe.populartvseries.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(), MainPresenter.MainView {

  @Inject lateinit var presenter: MainPresenter
  override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
    get() = ActivityMainBinding::inflate

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    presenter.attachView(this)
  }

  override fun showItems(tvSeries: List<TvSerieViewEntity>) {
    TODO("Not yet implemented")
  }

  override fun showLoading() {
  }

  override fun hideLoading() {
  }
}