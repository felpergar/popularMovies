package com.felipe.popularTvSeries.mobile.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.felipe.popularTvSeries.mobile.common.BaseActivity
import com.felipe.popularTvSeries.mobile.common.showToast
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity
import com.felipe.populartvseries.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>(), DetailPresenter.DetailView {

  companion object {
    private const val TV_SERIE_INFO = "tvSerieInfo"
    fun getCallingIntent(context: Context, tvSerieInfo: TvSerieViewEntity) = Intent(context, DetailActivity::class.java).apply {
      putExtra(TV_SERIE_INFO, tvSerieInfo)
    }
  }

  override val bindingInflater: (LayoutInflater) -> ActivityDetailBinding = ActivityDetailBinding::inflate

  private val tvSerieInfo by lazy { intent.getParcelableExtra(TV_SERIE_INFO) as? TvSerieViewEntity }
  private val presenter by lazy { DetailPresenter(tvSerieInfo) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.attachView(this)
  }

  override fun showError() {
    showToast("Something was wrong to show the info")
  }

  override fun showInfo(info: TvSerieViewEntity) {
    showToast("Everything was ok to show the info")
  }

  override fun showLoading() {

  }

  override fun hideLoading() {

  }
}