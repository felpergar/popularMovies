package com.felipe.popularTvSeries.mobile.mainView

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipe.popularTvSeries.mobile.common.BaseActivity
import com.felipe.popularTvSeries.mobile.detail.DetailActivity
import com.felipe.popularTvSeries.mobile.mainView.adapter.TvSerieAdapter
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity
import com.felipe.populartvseries.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(), MainPresenter.MainView {

  @Inject lateinit var presenter: MainPresenter
  override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
    get() = ActivityMainBinding::inflate

  private val tvSerieAdapter by lazy { TvSerieAdapter(presenter::onTvSerieSelected) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    presenter.attachView(this)
  }

  override fun initRecyclerView() {
    with(binding.mainRecyclerView) {
      layoutManager = LinearLayoutManager(this@MainActivity)
      setHasFixedSize(true)
      if (adapter == null)
        adapter = tvSerieAdapter
    }
  }

  override fun showItems(tvSeries: List<TvSerieViewEntity>) {
    tvSerieAdapter.setItems(tvSeries)
  }

  override fun openTvSerieDetail(tvSerie: TvSerieViewEntity) {
    startActivity(DetailActivity.getCallingIntent(this, tvSerie))
  }

  override fun showLoading() {
    binding.loader.visibility = VISIBLE
  }

  override fun hideLoading() {
    binding.loader.visibility = GONE
  }
}