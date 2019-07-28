package com.mahmoud.mostafa.marvel.ui.details.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.mahmoud.mostafa.marvel.R
import com.mahmoud.mostafa.marvel.data.pojos.characters.Results

public class ComicsAdapter(private val characterArrayList: List<Results>, private val context: Context) : RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>() {
    private val imageType = "standard_amazing"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.comics_row, parent, false)
        return ComicsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {

        val character = characterArrayList[position]
        if (character.thumbnail != null) {
            Glide.with(context).load(character.thumbnail.path + "/" + imageType + "." +
                    character.thumbnail.extension).into(holder.comicImage)
        } else {
            Glide.with(context).load("http://i.annihil.us/u/prod/marvel/i/mg/9/80/59d2acf17c923" + "/" + imageType + "." +
                    "jpg").into(holder.comicImage)
        }
        holder.comicName.text = character.title


    }

    override fun getItemCount(): Int {
        return characterArrayList.size
    }

    inner class ComicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var comicImage: ImageView
        var comicName: TextView

        init {
            comicImage = itemView.findViewById(R.id.comic_image)
            comicName = itemView.findViewById(R.id.comic_name)
        }
    }
}
