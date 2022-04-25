package com.felipe.popularTvSeries.mobile.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import com.felipe.popularTvSeries.mobile.common.BaseActivity
import com.felipe.popularTvSeries.mobile.common.ORIGINAL_SIZE
import com.felipe.popularTvSeries.mobile.common.load
import com.felipe.popularTvSeries.mobile.common.showToast
import com.felipe.popularTvSeries.mobile.detail.model.TvSerieInfoViewEntity
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity
import com.felipe.populartvseries.R
import com.felipe.populartvseries.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>(), DetailPresenter.DetailView {

  companion object {
    private const val ID = "id"
    private const val DEFAULT_ID = 0
    fun getCallingIntent(context: Context, id: Int) = Intent(context, DetailActivity::class.java).apply {
      putExtra(ID, id)
    }
  }

  override val bindingInflater: (LayoutInflater) -> ActivityDetailBinding = ActivityDetailBinding::inflate

  private val id by lazy { intent.getIntExtra(ID, DEFAULT_ID) }
  @Inject lateinit var presenter: DetailPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.attachView(this)
  }

  override fun onViewInit() {
    presenter.initProcess(id)
  }

  override fun showError() {
    showToast(getString(R.string.error_message))
  }

  override fun showInfo(info: TvSerieInfoViewEntity) {
    with(binding) {
      serieImage.load(info.backdropImage, ORIGINAL_SIZE)
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