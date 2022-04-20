package com.felipe.popularTvSeries.domain

import com.felipe.popularTvSeries.data.common.ResultWrapper

interface UseCaseAsync<in RQ, RS> {

  suspend fun buildAsync(params: RQ): ResultWrapper<RS>
}