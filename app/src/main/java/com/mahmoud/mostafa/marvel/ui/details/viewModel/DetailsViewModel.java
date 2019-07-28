package com.mahmoud.mostafa.marvel.ui.details.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;
import com.mahmoud.mostafa.marvel.ui.details.repository.DetailsRepository;

public class DetailsViewModel extends ViewModel {
    DetailsRepository repository;

    public void init() {
        repository = DetailsRepository.getInstance();
    }

    public MutableLiveData<Character> getComics(String id) {
        return repository.getComics(id);
    }

    public MutableLiveData<Character> getSeries(String id) {
        return repository.getSeries(id);
    }

    public MutableLiveData<Character> getStories(String id) {
        return repository.getStories(id);
    }

    public MutableLiveData<Character> getEvents(String id) {
        return repository.getEvents(id);
    }

}
