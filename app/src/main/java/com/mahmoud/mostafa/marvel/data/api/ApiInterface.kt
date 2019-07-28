package com.mahmoud.mostafa.marvel.data.api

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("characters")
    fun getCharacters(@Query("ts") timeStamp: String, @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<Character>


    @GET("characters")
    fun getCharactersByName(@Query("ts") timeStamp: String, @Query("apikey") apiKey: String, @Query("hash")
    hash: String, @Query("nameStartsWith") name: String): Call<Character>

    @GET("characters/{characterId}/comics")
    fun getComics(@Path("characterId") characterId: String, @Query("ts") timeStamp: String,
                  @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<Character>


    @GET("characters/{characterId}/events")
    fun getEvents(@Path("characterId") characterId: String, @Query("ts") timeStamp: String,
                  @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<Character>

    @GET("characters/{characterId}/series")
    fun getSeries(@Path("characterId") characterId: String, @Query("ts") timeStamp: String,
                  @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<Character>


    @GET("characters/{characterId}/stories")
    fun getStories(@Path("characterId") characterId: String, @Query("ts") timeStamp: String,
                   @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<Character>


}
