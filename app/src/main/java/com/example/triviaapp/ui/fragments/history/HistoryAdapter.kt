package com.example.triviaapp.ui.fragments.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaapp.data.Trivia
import com.example.triviaapp.databinding.ItemHistoryBinding

class HistoryAdapter : ListAdapter<Trivia, HistoryAdapter.TriviaViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TriviaViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TriviaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TriviaViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class TriviaViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(trivia: Trivia) {
            binding.apply {
                textGameDate.text = "Game ${trivia.id}: ${trivia.dateTimeFormatted}"
                textName.text = "Name: ${trivia.name}"
                textBestCricketerAnswer.text = "Answer: ${trivia.cricketerName}"
                textFlagAnswer.text = "Answers: ${trivia.flagColors}"
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Trivia>() {
        override fun areItemsTheSame(oldItem: Trivia, newItem: Trivia) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Trivia, newItem: Trivia): Boolean =
            oldItem == newItem

    }
}