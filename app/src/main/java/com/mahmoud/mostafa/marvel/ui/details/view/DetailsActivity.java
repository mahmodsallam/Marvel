package com.mahmoud.mostafa.marvel.ui.details.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mahmoud.mostafa.marvel.R;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Results;
import com.mahmoud.mostafa.marvel.ui.details.adapters.ComicsAdapter;
import com.mahmoud.mostafa.marvel.ui.details.viewModel.DetailsViewModel;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView characterName;
    private TextView characterDescription;
    private ImageView characterImage;
    private String normalImage = "portrait_incredible";
    private RecyclerView comicsRecycler, seriesRecycler, eventsRecycler, storiesRecycler;
    private ComicsAdapter comicsAdapter, seriesAdapter, eventsAdapter, storiesAdapter;
    private ImageView backArrow;
    private ImageView backImage;
    private TextView titleText;
    private DetailsViewModel detailsViewModel;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Results character = getIntent().getParcelableExtra("character");
        id = character.getId().toString();
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        detailsViewModel.init();

        setUpViews();
        bindData(character);
        getRemoteDate();

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getRemoteDate() {

        detailsViewModel.getComics(id).observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                setComicsData(character.getData().getResults());
            }
        });

        detailsViewModel.getEvents(id).observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                setEventsData(character.getData().getResults());
            }
        });

        detailsViewModel.getSeries(id).observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                setSeriesData(character.getData().getResults());
            }
        });

        detailsViewModel.getStories(id).observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                setStoriesData(character.getData().getResults());
            }
        });
    }

    private void bindData(Results character) {
        characterName.setText(character.getName());
        characterDescription.setText(character.getDescription());
        Glide.with(getApplicationContext()).load(character.getThumbnail().getPath() + "/" + normalImage + "." +
                character.getThumbnail().getExtension()).into(
                characterImage);
        Glide.with(getApplicationContext()).load(character.getThumbnail().getPath() + "/" + normalImage + "." +
                character.getThumbnail().getExtension()).into(
                backImage);

        titleText.setText(character.getName());
    }


    private void setComicsData(List<Results> results) {
        comicsAdapter = new ComicsAdapter(results, this);
        setupRecycler(comicsRecycler);
        comicsRecycler.setAdapter(comicsAdapter);
    }


    private void setSeriesData(List<Results> results) {
        seriesAdapter = new ComicsAdapter(results, this);
        setupRecycler(seriesRecycler);
        seriesRecycler.setAdapter(seriesAdapter);
    }


    private void setStoriesData(List<Results> results) {
        storiesAdapter = new ComicsAdapter(results, this);
        setupRecycler(storiesRecycler);
        storiesRecycler.setAdapter(storiesAdapter);
    }


    private void setEventsData(List<Results> results) {
        eventsAdapter = new ComicsAdapter(results, this);
        setupRecycler(eventsRecycler);
        eventsRecycler.setAdapter(eventsAdapter);
    }

    private void setupRecycler(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setUpViews() {
        toolbar = findViewById(R.id.toolbar);
        characterName = findViewById(R.id.character_name);
        characterDescription = findViewById(R.id.character_desc);
        characterImage = findViewById(R.id.character_image);
        comicsRecycler = findViewById(R.id.comics_recycler);
        seriesRecycler = findViewById(R.id.series_recycler);
        eventsRecycler = findViewById(R.id.events_recycler);
        storiesRecycler = findViewById(R.id.stories_recycler);
        titleText = findViewById(R.id.title_text);
        backArrow = findViewById(R.id.back_arrow);
        backImage = findViewById(R.id.back_image);
        setSupportActionBar(toolbar);
    }
}
