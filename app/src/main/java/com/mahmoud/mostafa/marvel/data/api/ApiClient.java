package com.mahmoud.mostafa.marvel.data.api;

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class ApiClient implements ApiInterface {

    ApiInterface apiInterface;

    public ApiClient() {
        Retrofit instance = RetrofitInstance.getInstance();
        apiInterface = instance.create(ApiInterface.class);
    }

    @Override
    public Observable<Character> getCharacters(String timeStamp, String apiKey, String hash) {
        return apiInterface.getCharacters(timeStamp, apiKey, hash);
    }

    @Override
    public Observable<Character> getCharactersByName(String timeStamp, String apiKey, String hash, String name) {
        return apiInterface.getCharactersByName(timeStamp, apiKey, hash, name);
    }

    @Override
    public Observable<Character> getComics(String characterId, String timeStamp, String apiKey, String hash) {
        return apiInterface.getComics(characterId, timeStamp, apiKey, hash);
    }

    @Override
    public Observable<Character> getEvents(String characterId, String timeStamp, String apiKey, String hash) {
        return apiInterface.getEvents(characterId, timeStamp, apiKey, hash);
    }

    @Override
    public Observable<Character> getSeries(String characterId, String timeStamp, String apiKey, String hash) {
        return apiInterface.getSeries(characterId, timeStamp, apiKey, hash);
    }

    @Override
    public Observable<Character> getStories(String characterId, String timeStamp, String apiKey, String hash) {
        return apiInterface.getStories(characterId, timeStamp, apiKey, hash);
    }


}
