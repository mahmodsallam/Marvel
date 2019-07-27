package com.mahmoud.mostafa.marvel.ui.details.presenter;

import com.mahmoud.mostafa.marvel.data.pojos.characters.Results;

import java.util.List;

public interface DetailsMvpView {
    void setComicsData(List<Results> results) ;
    void setSeriesData(List<Results> results) ;
    void setStoriesData(List<Results> results) ;
    void setEventsData(List<Results> results) ;

}
