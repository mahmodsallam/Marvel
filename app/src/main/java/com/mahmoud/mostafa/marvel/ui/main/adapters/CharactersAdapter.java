package com.mahmoud.mostafa.marvel.ui.main.adapters;

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
import com.mahmoud.mostafa.marvel.ui.main.DetailsInterface;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder> {

    private List<Results> characterArrayList;
    private Context context;
    private Boolean isSearch;
    private String searchImageType = "standard_large";
    private String normalImage = "landscape_xlarge";
    private DetailsInterface detailsInterface;

    public CharactersAdapter(List<Results> characterArrayList, Context context, Boolean isSearch, DetailsInterface detailsInterface) {
        this.characterArrayList = characterArrayList;
        this.context = context;
        this.isSearch = isSearch;
        this.detailsInterface = detailsInterface;
    }

    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (isSearch == true) {
            view = LayoutInflater.from(context).inflate(R.layout.search_row, parent, false);

        } else {
            view = LayoutInflater.from(context).inflate(R.layout.character_row, parent, false);
        }
        return new CharactersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder holder, int position) {
        final Results character = characterArrayList.get(position);
        if (isSearch == true) {
            Glide.with(context).load(character.getThumbnail().getPath() + "/" + searchImageType + "." +
                            character.getThumbnail().getExtension()).into(
                            holder.characterImage
            );
        } else {
            Glide.with(context).load(character.getThumbnail().getPath() + "/" + normalImage + "." +
                    character.getThumbnail().getExtension()).into(
                    holder.characterImage
            );
        }

        holder.characterName.setText(character.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsInterface.openDetails(character);
            }
        });


    }

    @Override
    public int getItemCount() {
        return characterArrayList.size();
    }

    class CharactersViewHolder extends RecyclerView.ViewHolder {
        ImageView characterImage;
        TextView characterName;

        public CharactersViewHolder(@NonNull View itemView) {
            super(itemView);
            characterImage = itemView.findViewById(R.id.character_image);
            characterName = itemView.findViewById(R.id.character_name);
        }
    }
}
