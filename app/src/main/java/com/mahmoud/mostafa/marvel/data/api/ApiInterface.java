package com.mahmoud.mostafa.marvel.data.api;

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("characters")
    Call<Character> getCharacters(@Query("ts") String timeStamp, @Query("apikey") String apiKey, @Query("hash") String hash);


    @GET("characters")
    Call<Character> getCharactersByName(@Query("ts") String timeStamp, @Query("apikey") String apiKey, @Query("hash")
            String hash, @Query("nameStartsWith") String name);

    @GET("characters/{characterId}/comics")
    Call<Character> getComics(@Path("characterId") String characterId, @Query("ts") String timeStamp,
                                    @Query("apikey") String apiKey, @Query("hash") String hash);


    @GET("characters/{characterId}/events")
    Call<Character> getEvents(@Path("characterId") String characterId, @Query("ts") String timeStamp,
                                    @Query("apikey") String apiKey, @Query("hash") String hash);

    @GET("characters/{characterId}/series")
    Call<Character> getSeries(@Path("characterId") String characterId, @Query("ts") String timeStamp,
                                    @Query("apikey") String apiKey, @Query("hash") String hash);


    @GET("characters/{characterId}/stories")
    Call<Character> getStories(@Path("characterId") String characterId, @Query("ts") String timeStamp,
                                     @Query("apikey") String apiKey, @Query("hash") String hash);


}
