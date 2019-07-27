package com.mahmoud.mostafa.marvel.ui.details.presenter;

public interface DetailsMvpPresenter {
    void getComics(String characterId);
    void getSeries(String characterId);
    void getStories(String characterId);
    void getEvents(String characterId);


}
