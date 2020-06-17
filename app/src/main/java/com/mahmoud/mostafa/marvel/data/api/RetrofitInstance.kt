package com.mahmoud.mostafa.marvel.data.api

import com.mahmoud.mostafa.marvel.base.MyApplication
import com.mahmoud.mostafa.marvel.utils.Constants

import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val HEADER_CACHE_CONTROL = "Cache-Control"
    private val HEADER_PRAGMA = "Pragma"
    private val cacheSize = (15 * 1024 * 1024).toLong()
            private lateinit var  instance: Retrofit

    private val httpClient: OkHttpClient
        get() = OkHttpClient()
                .newBuilder()
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(networkInterceptor)
                .addInterceptor(offlineInterceptor)
                .cache(cache)
                .build()

    private// prevent caching when network is on. For that we use the "networkInterceptor"
    val offlineInterceptor: Interceptor
        get() = Interceptor { chain ->
            var request = chain.request()
            if (!MyApplication.hasNetwork()) {
                val cacheControl = CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build()
                request = request.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .cacheControl(cacheControl)
                        .build()
            }

            chain.proceed(request)
        }

    private val networkInterceptor: Interceptor
        get() = Interceptor { chain ->
            val response = chain.proceed(chain.request())
            val cacheControl = CacheControl.Builder()
                    .maxAge(5, TimeUnit.SECONDS)
                    .build()
            response.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                    .build()
        }

    private val loggingInterceptor: HttpLoggingInterceptor
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }

    private val cache: Cache
        get() = Cache(File(MyApplication.instance?.getCacheDir(), "characters"), cacheSize)

    fun getInstance(): Retrofit {
            instance = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        return instance
    }
}
