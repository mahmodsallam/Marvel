package com.mahmoud.mostafa.marvel.ui.details.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.mahmoud.mostafa.marvel.R
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character
import com.mahmoud.mostafa.marvel.data.pojos.characters.Results
import com.mahmoud.mostafa.marvel.ui.details.adapters.ComicsAdapter
import com.mahmoud.mostafa.marvel.ui.details.viewModel.DetailsViewModel

class DetailsActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private var characterName: TextView? = null
    private var characterDescription: TextView? = null
    private var characterImage: ImageView? = null
    private val normalImage = "portrait_incredible"
    private var comicsRecycler: RecyclerView? = null
    private var seriesRecycler: RecyclerView? = null
    private var eventsRecycler: RecyclerView? = null
    private var storiesRecycler: RecyclerView? = null
    private var comicsAdapter: ComicsAdapter? = null
    private var seriesAdapter: ComicsAdapter? = null
    private var eventsAdapter: ComicsAdapter? = null
    private var storiesAdapter: ComicsAdapter? = null
    private var backArrow: ImageView? = null
    private var backImage: ImageView? = null
    private var titleText: TextView? = null
    private var detailsViewModel: DetailsViewModel? = null
    private lateinit var  id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val character = intent.getParcelableExtra<Results>("character")
        id = character.id!!.toString()
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        detailsViewModel!!.init()

        setUpViews()
        bindData(character)
        getRemoteDate()

        backArrow!!.setOnClickListener { finish() }
    }

    private fun getRemoteDate() {

        detailsViewModel!!.getComics(id).observe(this , Observer { character -> setComicsData(character.data.results) })

        detailsViewModel!!.getEvents(id).observe(this, Observer { character -> setEventsData(character.data.results) })

        detailsViewModel!!.getSeries(id).observe(this, Observer { character -> setSeriesData(character.data.results) })

        detailsViewModel!!.getStories(id).observe(this, Observer { character -> setStoriesData(character.data.results) })
    }

    private fun bindData(character: Results) {
        characterName!!.text = character.name
        characterDescription!!.text = character.description
        Glide.with(applicationContext).load(character.thumbnail.path + "/" + normalImage + "." +
                character.thumbnail.extension).into(
                characterImage!!)
        Glide.with(applicationContext).load(character.thumbnail.path + "/" + normalImage + "." +
                character.thumbnail.extension).into(
                backImage!!)

        titleText!!.text = character.name
    }


    private fun setComicsData(results: List<Results>) {
        comicsAdapter = ComicsAdapter(results, this)
        setupRecycler(comicsRecycler!!)
        comicsRecycler!!.adapter = comicsAdapter
    }


    private fun setSeriesData(results: List<Results>) {
        seriesAdapter = ComicsAdapter(results, this)
        setupRecycler(seriesRecycler!!)
        seriesRecycler!!.adapter = seriesAdapter
    }


    private fun setStoriesData(results: List<Results>) {
        storiesAdapter = ComicsAdapter(results, this)
        setupRecycler(storiesRecycler!!)
        storiesRecycler!!.adapter = storiesAdapter
    }


    private fun setEventsData(results: List<Results>) {
        eventsAdapter = ComicsAdapter(results, this)
        setupRecycler(eventsRecycler!!)
        eventsRecycler!!.adapter = eventsAdapter
    }

    private fun setupRecycler(recyclerView: RecyclerView) {
        val layoutManager = LinearLayoutManager(applicationContext,
                LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun setUpViews() {
        toolbar = findViewById(R.id.toolbar)
        characterName = findViewById(R.id.character_name)
        characterDescription = findViewById(R.id.character_desc)
        characterImage = findViewById(R.id.character_image)
        comicsRecycler = findViewById(R.id.comics_recycler)
        seriesRecycler = findViewById(R.id.series_recycler)
        eventsRecycler = findViewById(R.id.events_recycler)
        storiesRecycler = findViewById(R.id.stories_recycler)
        titleText = findViewById(R.id.title_text)
        backArrow = findViewById(R.id.back_arrow)
        backImage = findViewById(R.id.back_image)
        setSupportActionBar(toolbar)
    }
}
