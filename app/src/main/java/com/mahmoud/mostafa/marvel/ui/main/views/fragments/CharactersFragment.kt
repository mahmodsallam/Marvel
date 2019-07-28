package com.mahmoud.mostafa.marvel.ui.main.views.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mahmoud.mostafa.marvel.R
import com.mahmoud.mostafa.marvel.data.pojos.characters.Character
import com.mahmoud.mostafa.marvel.data.pojos.characters.Results
import com.mahmoud.mostafa.marvel.ui.details.view.DetailsActivity
import com.mahmoud.mostafa.marvel.ui.main.DetailsInterface
import com.mahmoud.mostafa.marvel.ui.main.adapters.CharactersAdapter
import com.mahmoud.mostafa.marvel.ui.main.viewModel.MainViewModel


class CharactersFragment : Fragment(), DetailsInterface {

    private var adapter: CharactersAdapter? = null
    private var charactersRecyclerView: RecyclerView? = null
    private var toolbar: Toolbar? = null
    private var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_characters, container, false)
        toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar!!.title = null
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_search) {
            showSearchFragment()

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersRecyclerView = view.findViewById(R.id.character_recyclerView)

        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        mainViewModel!!.init()
        mainViewModel!!.characters.observe(activity!!, Observer { character -> setData(character.data.results) })

    }


    private fun setData(results: List<Results>) {
        adapter = CharactersAdapter(results, activity!!.applicationContext, false, this)
        val layoutManager = LinearLayoutManager(activity!!.applicationContext)
        charactersRecyclerView!!.layoutManager = layoutManager
        charactersRecyclerView!!.itemAnimator = DefaultItemAnimator()
        charactersRecyclerView!!.adapter = adapter
    }


    override fun openDetails(results: Results) {
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("character", results)
        startActivity(intent)
    }

    private fun showSearchFragment() {
        activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_host, SearchFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }

    companion object {

        fun newInstance(): CharactersFragment {
            val fragment = CharactersFragment()
            val args = Bundle()
            return fragment
        }
    }

}
