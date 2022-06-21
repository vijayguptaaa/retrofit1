package com.example.loginvalidation.repository

import com.example.loginvalidation.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}