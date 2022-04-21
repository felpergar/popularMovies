package com.felipe.popularTvSeries.mobile.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.felipe.popularTvSeries.mobile.common.BaseActivity
import com.felipe.populartvseries.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>(), DetailPresenter.DetailView {

  companion object {
    private const val ID = "id"
    private const val DEFAULT_ID = "0"
    fun getCallingIntent(context: Context, tvSerieId: String) = Intent(context, DetailActivity::class.java).apply {
      putExtra(ID, tvSerieId)
    }
  }

  override val bindingInflater: (LayoutInflater) -> ActivityDetailBinding = ActivityDetailBinding::inflate

  private val id by lazy { intent.getStringExtra(ID) ?: DEFAULT_ID}
  private val presenter by lazy { DetailPresenter(id) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.attachView(this)
  }


  override fun showLoading() {

  }

  override fun hideLoading() {

  }
}