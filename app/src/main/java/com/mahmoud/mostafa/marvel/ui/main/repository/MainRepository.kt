package com.mahmoud.mostafa.marvel.ui.main.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mahmoud.mostafa.marvel.data.api.ApiClient
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character
import com.mahmoud.mostafa.marvel.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private val characters = MutableLiveData<Character>()
    private val charactersSearchResult = MutableLiveData<Character>()
    private val client = ApiClient()

    companion object {
        private lateinit var instance: MainRepository

        fun getInstance(): MainRepository {
            instance = MainRepository()
            return instance
        }
    }


    fun getCharacters(): MutableLiveData<Character> {

        val call = client.getCharacters(
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH)
        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                characters.value = response.body()
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.d("error", t.message)
            }
        })

        return characters
    }

    fun getCharactersByName(name: String): MutableLiveData<Character> {

        val call = client.getCharactersByName(
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH, name)
        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                charactersSearchResult.value = response.body()
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.d("error", t.message)
            }
        })

        return charactersSearchResult
    }


}
