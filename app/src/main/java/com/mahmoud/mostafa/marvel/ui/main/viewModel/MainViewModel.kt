package com.mahmoud.mostafa.marvel.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character
import com.mahmoud.mostafa.marvel.ui.main.repository.MainRepository

class MainViewModel : ViewModel() {
    internal lateinit var mainRepository: MainRepository

    val characters: MutableLiveData<Character>
        get() = mainRepository.getCharacters()

    fun init() {
        mainRepository = MainRepository.getInstance()
    }

    fun getCharacterByName(name: String): MutableLiveData<Character> {
        return mainRepository.getCharactersByName(name)
    }
}
