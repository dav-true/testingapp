package com.example.testingproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testingproject.Result
import com.example.testingproject.databinding.ResultViewBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecyclerViewAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var results: MutableList<Result> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ResultViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount() = results.size

    inner class ViewHolder(
        val binding: ResultViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result) {
            binding.result.text = result.text
        }
    }

    fun setResults(list: List<Result>) {
        results.clear()
        results.addAll(list)
        println(results.size)
        notifyDataSetChanged()
    }
}