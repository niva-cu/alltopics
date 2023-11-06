package com.nivs.all.db_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nivs.all.R
import com.nivs.all.databinding.ModelDbroomBinding

class WordsAdapter(): ListAdapter<Word, WordsAdapter.WordViewHolder>(WordDC()) {

    var itemClickListener: (Word) -> Unit = {}
    lateinit var binding : ModelDbroomBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordViewHolder(
        ModelDbroomBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WordViewHolder(private val binding: ModelDbroomBinding)  : RecyclerView.ViewHolder(binding.root){
        init {
            binding.items.setOnClickListener {
                itemClickListener(getItem(layoutPosition))
            }
        }

        fun bind(userInfoEntity: Word) {
            binding.words.text =userInfoEntity.word
        }
    }


    class WordDC : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id
        }
    }


}