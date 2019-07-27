package com.mahmoud.mostafa.marvel.ui.main.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
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

public class SearchFragment extends Fragment implements MainMvpView, DetailsInterface {
    private MainPresenter mainPresenter;
    private RecyclerView searchRecyclerView;
    private Toolbar toolbar;

    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchRecyclerView = view.findViewById(R.id.character_recyclerView);
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainPresenter = new MainPresenter(this);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem mSearch = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) mSearch.getActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mainPresenter.getCharactersByName(newText);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void setData(List<Results> results) {
        CharactersAdapter adapter = new CharactersAdapter(results, getActivity().getApplicationContext(), true, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        searchRecyclerView.setLayoutManager(layoutManager);
        searchRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(searchRecyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation()
        );
        searchRecyclerView.addItemDecoration(dividerItemDecoration);
        searchRecyclerView.setAdapter(adapter);
    }

    @Override
    public void openDetails(Results results) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("character", results);
        startActivity(intent);
    }
}
