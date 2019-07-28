package com.mahmoud.mostafa.marvel.ui.details.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.mahmoud.mostafa.marvel.data.pojos.characters.Character
import com.mahmoud.mostafa.marvel.ui.details.repository.DetailsRepository

class DetailsViewModel : ViewModel() {
    internal lateinit var repository: DetailsRepository

    fun init() {
        repository = DetailsRepository.getInstance()
    }

    fun getComics(id: String): MutableLiveData<Character> {
        return repository.getComics(id)
    }

    fun getSeries(id: String): MutableLiveData<Character> {
        return repository.getSeries(id)
    }

    fun getStories(id: String): MutableLiveData<Character> {
        return repository.getStories(id)
    }

    fun getEvents(id: String): MutableLiveData<Character> {
        return repository.getEvents(id)
    }

}
