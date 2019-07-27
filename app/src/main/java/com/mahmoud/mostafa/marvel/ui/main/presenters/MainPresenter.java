package com.mahmoud.mostafa.marvel.ui.main.presenters;

import android.util.Log;

import com.mahmoud.mostafa.marvel.data.api.ApiClient;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;
import com.mahmoud.mostafa.marvel.utils.Constants;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainMvpPresenter {
    MainMvpView mainView;
    ApiClient apiClient;

    public MainPresenter(MainMvpView mainView) {
        this.mainView = mainView;
        apiClient = new ApiClient();
    }

    @Override
    public void getCharchters() {
        apiClient.getCharacters(Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH)
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(
                        new Consumer<Character>() {
                            @Override
                            public void accept(Character character) throws Exception {
                                mainView.setData(character.getData().getResults());
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d("============", throwable.getMessage());
                            }
                        }


                );
    }

    @Override
    public void getCharactersByName(String name) {
        apiClient.getCharactersByName(Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH, name)
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(
                        new Consumer<Character>() {
                            @Override
                            public void accept(Character character) throws Exception {
                                mainView.setData(character.getData().getResults());
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d("============", throwable.getMessage());
                            }
                        }


                );
    }
}
