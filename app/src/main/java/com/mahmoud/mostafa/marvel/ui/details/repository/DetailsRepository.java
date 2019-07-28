package com.mahmoud.mostafa.marvel.ui.details.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.mahmoud.mostafa.marvel.data.api.ApiClient;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;
import com.mahmoud.mostafa.marvel.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsRepository {
    private static DetailsRepository instance;
    private MutableLiveData<Character> comics = new MutableLiveData<>();
    private MutableLiveData<Character> series = new MutableLiveData<>();
    private MutableLiveData<Character> stories = new MutableLiveData<>();
    private MutableLiveData<Character> events = new MutableLiveData<>();
    private ApiClient client = new ApiClient();

    public static DetailsRepository getInstance() {
        if (instance == null) {
            instance = new DetailsRepository();
        }

        return instance;
    }

    public MutableLiveData<Character> getComics(String id) {
        Call<Character> call = client.getComics(id,
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                comics.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });


        return comics;
    }

    public MutableLiveData<Character> getStories(String id) {
        Call<Character> call = client.getStories(id,
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                stories.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });

        return stories;

    }

    public MutableLiveData<Character> getSeries(String id) {

        Call<Character> call = client.getSeries(id,
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                series.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });

        return series;

    }

    public MutableLiveData<Character> getEvents(String id) {

        Call<Character> call = client.getEvents(id,
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                events.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });


        return events;
    }
}
