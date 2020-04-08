package com.example.media_app.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.example.media_app.data.network.dto.CharacterResponse
import com.example.media_app.databinding.ListItemCharacterBinding

class CharactersAdapter(private val characterListener: (CharacterResponse) -> Unit) :
        RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var characterList = mutableListOf<CharacterResponse>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = characterList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = ListItemCharacterBinding.inflate(inflater, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(character = characterList[position], listener = characterListener)
    }

    class ViewHolder(private val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterResponse, listener: (CharacterResponse) -> Unit) = with(binding) {
            setCharacter(character)
            characterImage.load(character.imageUrl) {
                crossfade(true)
                transformations(RoundedCornersTransformation(16f))
            }
        }
    }
}