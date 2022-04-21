package com.felipe.popularTvSeries.mobile.mainView.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity
import com.felipe.populartvseries.R
import com.felipe.populartvseries.databinding.AdapterTvSerieBinding

class TvSerieAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  var items: ArrayList<TvSerieViewEntity> = arrayListOf()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
    TvSerieViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.adapter_tv_serie, parent, false)
    )

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
    (holder as TvSerieViewHolder).bind(items[position])

  override fun getItemCount() = items.size

  fun setItems(tvSeries: List<TvSerieViewEntity>) {
    items.addAll(tvSeries)
    notifyDataSetChanged()
  }

  inner class TvSerieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: TvSerieViewEntity) {
      with(AdapterTvSerieBinding.bind(itemView)) {
        title.text = item.originalName
        score.text = item.voteAverage
        poster.load("$BASE_URL${item.posterImage}")
      }
    }
  }

  fun ImageView.load(url: String?) {
    Glide.with(this).load(url).into(this)
//    val glideUrl = GlideUrl(url, headers)
//    val requestBuilder = Glide.with(context)
//      .load(glideUrl)
//      .signature(GlideIntegerVersionSignature(context))
//      .apply(RequestOptions().downsample(DownsampleStrategy.AT_LEAST))
//    placeholderId?.let { requestBuilder.placeholder(placeholderId) }
//    requestBuilder.into(this)
  }

}

private const val BASE_URL = "https://image.tmdb.org/t/p/w500"