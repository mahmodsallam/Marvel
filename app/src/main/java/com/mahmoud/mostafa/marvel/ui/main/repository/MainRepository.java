package com.mahmoud.mostafa.marvel.ui.main.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.mahmoud.mostafa.marvel.data.api.ApiClient;
import com.mahmoud.mostafa.marvel.data.api.ApiInterface;
import com.mahmoud.mostafa.marvel.data.api.RetrofitInstance;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;
import com.mahmoud.mostafa.marvel.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainRepository {
    private static MainRepository instance;
    private MutableLiveData<Character> characters = new MutableLiveData<>();
    private MutableLiveData<Character> charactersSearchResult = new MutableLiveData<>();
    private ApiClient client = new ApiClient() ;

    public static MainRepository getInstance() {
        if (instance == null) {
            instance = new MainRepository();
        }

        return instance;
    }

    public MutableLiveData<Character> getCharacters() {

        Call<Character> call = client.getCharacters(
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                characters.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });

        return characters;
    }

    public MutableLiveData<Character> getCharactersByName(String name) {

        Call<Character> call = client.getCharactersByName(
                Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH ,name);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                charactersSearchResult.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });

        return charactersSearchResult;
    }
}
