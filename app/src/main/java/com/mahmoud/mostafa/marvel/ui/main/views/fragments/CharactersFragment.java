package com.mahmoud.mostafa.marvel.ui.main.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.mostafa.marvel.R;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Results;
import com.mahmoud.mostafa.marvel.ui.details.view.DetailsActivity;
import com.mahmoud.mostafa.marvel.ui.main.DetailsInterface;
import com.mahmoud.mostafa.marvel.ui.main.adapters.CharactersAdapter;
import com.mahmoud.mostafa.marvel.ui.main.presenters.MainMvpView;
import com.mahmoud.mostafa.marvel.ui.main.presenters.MainPresenter;

import java.util.List;

public class CharactersFragment extends Fragment implements MainMvpView, DetailsInterface {
    private MainPresenter mainPresenter;
    private CharactersAdapter adapter;
    private RecyclerView charactersRecyclerView;
    private Toolbar toolbar;


    public CharactersFragment() {
    }

    public static CharactersFragment newInstance() {
        CharactersFragment fragment = new CharactersFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            showSearchFragment();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        charactersRecyclerView = view.findViewById(R.id.character_recyclerView);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getCharchters();
    }


    @Override
    public void setData(List<Results> results) {
        adapter = new CharactersAdapter(results, getActivity().getApplicationContext(), false, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        charactersRecyclerView.setLayoutManager(layoutManager);
        charactersRecyclerView.setItemAnimator(new DefaultItemAnimator());
        charactersRecyclerView.setAdapter(adapter);
    }


    @Override
    public void openDetails(Results results) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("character", results);
        startActivity(intent);
    }

    private void showSearchFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_host, SearchFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

}
