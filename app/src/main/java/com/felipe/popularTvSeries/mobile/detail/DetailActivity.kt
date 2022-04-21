package com.felipe.popularTvSeries.mobile.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import com.felipe.popularTvSeries.mobile.common.BaseActivity
import com.felipe.popularTvSeries.mobile.common.load
import com.felipe.popularTvSeries.mobile.common.showToast
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity
import com.felipe.populartvseries.R
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
    showToast(getString(R.string.error_message))
  }

  override fun showInfo(info: TvSerieViewEntity) {
    with(binding) {
      serieImage.load(info.backdropImage)
      title.text = info.originalName
      score.text = info.voteAverage
      description.text = info.description
    }
    //We can add more information here
  }

  override fun showLoading() {
    binding.loader.visibility = VISIBLE
  }

  override fun hideLoading() {
    binding.loader.visibility = GONE
  }
}