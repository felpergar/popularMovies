package com.felipe.popularmovies.domain

import com.felipe.popularmovies.data.common.ResultWrapper

interface UseCaseAsync<in RQ, RS> {

  suspend fun buildAsync(params: RQ): ResultWrapper<RS>
}