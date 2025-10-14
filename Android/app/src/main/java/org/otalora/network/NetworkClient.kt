package org.otalora.network

object NetworkClient {
    private val retrofit= ApiConfig.createRetrofit();

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    };
}