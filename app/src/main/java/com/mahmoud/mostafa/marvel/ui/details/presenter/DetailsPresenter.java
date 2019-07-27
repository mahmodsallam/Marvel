package com.mahmoud.mostafa.marvel.ui.details.presenter;

import android.util.Log;

import com.mahmoud.mostafa.marvel.data.api.ApiClient;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;
import com.mahmoud.mostafa.marvel.utils.Constants;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailsPresenter implements DetailsMvpPresenter {
    ApiClient apiClient;
    DetailsMvpView mvpView;

    public DetailsPresenter(DetailsMvpView mvpView) {
        this.mvpView = mvpView;
        apiClient = new ApiClient();
    }

    @Override
    public void getComics(final String characterId) {
        apiClient.getComics(characterId, Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Character>() {
                    @Override
                    public void accept(Character comics) throws Exception {
                        mvpView.setComicsData(comics.getData().getResults());


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d("++++++++++++++", throwable.getMessage());
                    }
                });

    }

    @Override
    public void getSeries(String characterId) {
        apiClient.getSeries(characterId, Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Character>() {
                    @Override
                    public void accept(Character comics) throws Exception {
                        mvpView.setSeriesData(comics.getData().getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d("++++++++++++++", throwable.getMessage());
                    }
                });
    }

    @Override
    public void getStories(String characterId) {
        apiClient.getStories(characterId, Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Character>() {
                    @Override
                    public void accept(Character comics) throws Exception {
                        mvpView.setStoriesData(comics.getData().getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d("++++++++++++++", throwable.getMessage());
                    }
                });
    }

    @Override
    public void getEvents(String characterId) {
        apiClient.getEvents(characterId, Constants.TIME_STAMP, Constants.PUBLIC_API_KEY, Constants.HASH).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Character>() {
                    @Override
                    public void accept(Character comics) throws Exception {
                        mvpView.setEventsData(comics.getData().getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d("++++++++++++++", throwable.getMessage());
                    }
                });
    }


}
