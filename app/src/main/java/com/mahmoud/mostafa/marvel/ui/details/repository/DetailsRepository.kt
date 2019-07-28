package com.mahmoud.mostafa.marvel.ui.details.repository

import android.util.Log

import androidx.lifecycle.MutableLiveData

import com.mahmoud.mostafa.marvel.data.api.ApiClient
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character
import com.mahmoud.mostafa.marvel.utils.Constants

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsRepository {
    private val comics = MutableLiveData<Character>()
    private val series = MutableLiveData<Character>()
    private val stories = MutableLiveData<Character>()
    private val events = MutableLiveData<Character>()
    private val client = ApiClient()

    fun getComics(id: String): MutableLiveData<Character> {
        val call = client.getComics(id,
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH)
        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                comics.value = response.body()
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.d("error", t.message)
            }
        })


        return comics
    }

    fun getStories(id: String): MutableLiveData<Character> {
        val call = client.getStories(id,
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH)
        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                stories.value = response.body()
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.d("error", t.message)
            }
        })

        return stories

    }

    fun getSeries(id: String): MutableLiveData<Character> {

        val call = client.getSeries(id,
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH)
        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                series.value = response.body()
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.d("error", t.message)
            }
        })

        return series

    }

    fun getEvents(id: String): MutableLiveData<Character> {

        val call = client.getEvents(id,
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH)
        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                events.value = response.body()
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.d("error", t.message)
            }
        })


        return events
    }

    companion object {
        private lateinit var instance: DetailsRepository

        fun getInstance(): DetailsRepository {

            instance = DetailsRepository()

            return instance
        }
    }
}
