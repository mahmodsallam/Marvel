package com.mahmoud.mostafa.marvel.ui.details.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mahmoud.mostafa.marvel.R;
import com.mahmoud.mostafa.marvel.data.pojos.characters.Results;

import java.util.List;

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder> {

    private List<Results> characterArrayList;
    private Context context;
    private String imageType = "standard_amazing";


    public ComicsAdapter(List<Results> characterArrayList, Context context) {
        this.characterArrayList = characterArrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public ComicsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comics_row, parent, false);
        return new ComicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicsViewHolder holder, int position) {

        final Results character = characterArrayList.get(position);
        if (character.getThumbnail() != null) {
            Glide.with(context).load(character.getThumbnail().getPath() + "/" + imageType + "." +
                    character.getThumbnail().getExtension()).into(holder.comicImage);
        } else {
            Glide.with(context).load("http://i.annihil.us/u/prod/marvel/i/mg/9/80/59d2acf17c923" + "/" + imageType + "." +
                    "jpg").into(holder.comicImage);
        }
        holder.comicName.setText(character.getTitle());


    }

    @Override
    public int getItemCount() {
        return characterArrayList.size();
    }

    class ComicsViewHolder extends RecyclerView.ViewHolder {
        ImageView comicImage;
        TextView comicName;

        public ComicsViewHolder(@NonNull View itemView) {
            super(itemView);
            comicImage = itemView.findViewById(R.id.comic_image);
            comicName = itemView.findViewById(R.id.comic_name);
        }
    }
}
