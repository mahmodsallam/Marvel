package com.mahmoud.mostafa.marvel.data.api

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character
import retrofit2.Call

class ApiClient : ApiInterface {

    internal var apiInterface: ApiInterface

    init {
        val instance = RetrofitInstance.getInstance()
        apiInterface = instance.create(ApiInterface::class.java)
    }

    override fun getCharacters(timeStamp: String, apiKey: String, hash: String): Call<Character> {
        return apiInterface.getCharacters(timeStamp, apiKey, hash)
    }

    override fun getCharactersByName(timeStamp: String, apiKey: String, hash: String, name: String): Call<Character> {
        return apiInterface.getCharactersByName(timeStamp, apiKey, hash, name)
    }

    override fun getComics(characterId: String, timeStamp: String, apiKey: String, hash: String): Call<Character> {
        return apiInterface.getComics(characterId, timeStamp, apiKey, hash)
    }

    override fun getEvents(characterId: String, timeStamp: String, apiKey: String, hash: String): Call<Character> {
        return apiInterface.getEvents(characterId, timeStamp, apiKey, hash)
    }

    override fun getSeries(characterId: String, timeStamp: String, apiKey: String, hash: String): Call<Character> {
        return apiInterface.getSeries(characterId, timeStamp, apiKey, hash)
    }

    override fun getStories(characterId: String, timeStamp: String, apiKey: String, hash: String): Call<Character> {
        return apiInterface.getStories(characterId, timeStamp, apiKey, hash)
    }


}
