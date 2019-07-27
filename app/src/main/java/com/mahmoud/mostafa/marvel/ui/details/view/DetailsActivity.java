package com.mahmoud.mostafa.marvel.ui.details.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mahmoud.mostafa.marvel.R;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Results;
import com.mahmoud.mostafa.marvel.ui.details.adapters.ComicsAdapter;
import com.mahmoud.mostafa.marvel.ui.details.presenter.DetailsMvpView;
import com.mahmoud.mostafa.marvel.ui.details.presenter.DetailsPresenter;

import java.util.List;

public class DetailsActivity extends AppCompatActivity implements DetailsMvpView {

    private Toolbar toolbar;
    private TextView characterName;
    private TextView characterDescription;
    private ImageView characterImage;
    private String normalImage = "portrait_incredible";
    private DetailsPresenter mPresenter;
    private RecyclerView comicsRecycler, seriesRecycler, eventsRecycler, storiesRecycler;
    private ComicsAdapter comicsAdapter, seriesAdapter, eventsAdapter, storiesAdapter;
    private ImageView backArrow;
    private ImageView backImage;
    private TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setUpViews();
        Results character = getIntent().getParcelableExtra("character");
        bindData(character);

        mPresenter = new DetailsPresenter(this);
        mPresenter.getComics(character.getId().toString());
        mPresenter.getSeries(character.getId().toString());
        mPresenter.getStories(character.getId().toString());
        mPresenter.getEvents(character.getId().toString());


        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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


    @Override
    public void setComicsData(List<Results> results) {
        comicsAdapter = new ComicsAdapter(results, this);
        setupRecycler(comicsRecycler);
        comicsRecycler.setAdapter(comicsAdapter);
    }

    @Override
    public void setSeriesData(List<Results> results) {
        seriesAdapter = new ComicsAdapter(results, this);
        setupRecycler(seriesRecycler);
        seriesRecycler.setAdapter(seriesAdapter);
    }

    @Override
    public void setStoriesData(List<Results> results) {
        storiesAdapter = new ComicsAdapter(results, this);
        setupRecycler(storiesRecycler);
        storiesRecycler.setAdapter(storiesAdapter);
    }

    @Override
    public void setEventsData(List<Results> results) {
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
