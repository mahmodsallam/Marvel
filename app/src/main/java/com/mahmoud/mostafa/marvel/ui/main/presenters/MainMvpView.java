package com.mahmoud.mostafa.marvel.ui.main.presenters;

import com.mahmoud.mostafa.marvel.data.pojos.characters.Results;

import java.util.List;

public interface MainMvpView {
    void setData(List<Results> results) ;
}
