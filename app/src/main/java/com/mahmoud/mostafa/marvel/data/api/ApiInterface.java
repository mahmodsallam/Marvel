package com.mahmoud.mostafa.marvel.data.api;

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("characters")
    Observable<Character> getCharacters(@Query("ts") String timeStamp, @Query("apikey") String apiKey, @Query("hash") String hash);


    @GET("characters")
    Observable<Character> getCharactersByName(@Query("ts") String timeStamp, @Query("apikey") String apiKey, @Query("hash")
            String hash, @Query("nameStartsWith") String name);

    @GET("characters/{characterId}/comics")
    Observable<Character> getComics(@Path("characterId") String characterId, @Query("ts") String timeStamp,
                                    @Query("apikey") String apiKey, @Query("hash") String hash);


    @GET("characters/{characterId}/events")
    Observable<Character> getEvents(@Path("characterId") String characterId, @Query("ts") String timeStamp,
                                    @Query("apikey") String apiKey, @Query("hash") String hash);

    @GET("characters/{characterId}/series")
    Observable<Character> getSeries(@Path("characterId") String characterId, @Query("ts") String timeStamp,
                                    @Query("apikey") String apiKey, @Query("hash") String hash);


    @GET("characters/{characterId}/stories")
    Observable<Character> getStories(@Path("characterId") String characterId, @Query("ts") String timeStamp,
                                     @Query("apikey") String apiKey, @Query("hash") String hash);


}
