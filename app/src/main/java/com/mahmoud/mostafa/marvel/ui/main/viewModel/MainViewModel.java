package com.mahmoud.mostafa.marvel.ui.main.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;
import com.mahmoud.mostafa.marvel.ui.main.repository.MainRepository;

public class MainViewModel extends ViewModel {
    MainRepository mainRepository ;
    public void init (){
        mainRepository = MainRepository.getInstance() ;
    }

    public MutableLiveData<Character>getCharacters(){
        return mainRepository.getCharacters() ;
    }

    public MutableLiveData<Character>getCharacterByName(String name ){
        return mainRepository.getCharactersByName(name) ;
    }
}
