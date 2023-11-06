package com.nivs.all.coroutine.coroutine1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nivs.all.coroutine.coroutine1.model.Movie
import com.nivs.all.databinding.MovieItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movielist= mutableListOf<Movie>()

    class
    MovieViewHolder(val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val inflator= LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflator,parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movielist[position]
        holder.binding.name.text= movie.name
        //Picasso.get().load(movie.imageUrl).into(holder.binding.imageview)
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {

        return movielist.size
    }
    fun setMovies(movie: List<Movie>)
    {
        this.movielist=movie.toMutableList()
        notifyDataSetChanged()
    }
}