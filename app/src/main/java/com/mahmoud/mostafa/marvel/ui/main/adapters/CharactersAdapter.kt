package com.mahmoud.mostafa.marvel.ui.main.adapters

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
import com.mahmoud.mostafa.marvel.ui.main.DetailsInterface

class CharactersAdapter(private val characterArrayList: List<Results>, private val context: Context, private val isSearch: Boolean?, private val detailsInterface: DetailsInterface) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private val searchImageType = "standard_large"
    private val normalImage = "landscape_xlarge"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view: View
        if (isSearch == true) {
            view = LayoutInflater.from(context).inflate(R.layout.search_row, parent, false)

        } else {
            view = LayoutInflater.from(context).inflate(R.layout.character_row, parent, false)
        }
        return CharactersViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = characterArrayList[position]
        if (isSearch == true) {
            Glide.with(context).load(character.thumbnail.path + "/" + searchImageType + "." +
                    character.thumbnail.extension).into(
                    holder.characterImage
            )
        } else {
            Glide.with(context).load(character.thumbnail.path + "/" + normalImage + "." +
                    character.thumbnail.extension).into(
                    holder.characterImage
            )
        }

        holder.characterName.text = character.name

        holder.itemView.setOnClickListener { detailsInterface.openDetails(character) }


    }

    override fun getItemCount(): Int {
        return characterArrayList.size
    }

    inner class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var characterImage: ImageView
        var characterName: TextView

        init {
            characterImage = itemView.findViewById(R.id.character_image)
            characterName = itemView.findViewById(R.id.character_name)
        }
    }
}
