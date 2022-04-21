package com.felipe.popularTvSeries.mobile.common

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

  var _binding: T? = null
  val binding get() = _binding!!
  abstract val bindingInflater: (LayoutInflater) -> T

  override fun onCreate(savedInstanceState: Bundle?) {
    _binding = bindingInflater.invoke(layoutInflater)

    setContentView(binding.root)
    super.onCreate(savedInstanceState)
  }

  override fun onDestroy() {
    _binding = null
    super.onDestroy()
  }
}