package com.mahmoud.mostafa.marvel.ui.main.views.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mahmoud.mostafa.marvel.R
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character
import com.mahmoud.mostafa.marvel.data.pojos.characters.Results
import com.mahmoud.mostafa.marvel.ui.details.view.DetailsActivity
import com.mahmoud.mostafa.marvel.ui.main.DetailsInterface
import com.mahmoud.mostafa.marvel.ui.main.adapters.CharactersAdapter
import com.mahmoud.mostafa.marvel.ui.main.viewModel.MainViewModel

class SearchFragment : Fragment(), DetailsInterface {

    private var searchRecyclerView: RecyclerView? = null
    private var toolbar: Toolbar? = null
    private var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        searchRecyclerView = view.findViewById(R.id.character_recyclerView)
        toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar!!.title = null
        setHasOptionsMenu(true)

        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        mainViewModel!!.init()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        val mSearch = menu.findItem(R.id.action_search)
        val searchView = mSearch.actionView as SearchView
        searchView.setIconifiedByDefault(false)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {


                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                mainViewModel!!.getCharacterByName(newText.trim { it <= ' ' }).observe(activity!!, Observer { character ->
                    if (character != null) {
                        setData(character.data.results)
                    }
                })

                return true
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }


    private fun setData(results: List<Results>) {
        val adapter = CharactersAdapter(results, activity!!.applicationContext, true, this)
        val layoutManager = LinearLayoutManager(activity!!.applicationContext)
        searchRecyclerView!!.layoutManager = layoutManager
        searchRecyclerView!!.itemAnimator = DefaultItemAnimator()
        val dividerItemDecoration = DividerItemDecoration(searchRecyclerView!!.context,
                layoutManager.orientation
        )
        searchRecyclerView!!.addItemDecoration(dividerItemDecoration)
        searchRecyclerView!!.adapter = adapter
    }

    override fun openDetails(results: Results) {
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("character", results)
        startActivity(intent)
    }

    companion object {

        fun newInstance(): SearchFragment {
            val fragment = SearchFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
