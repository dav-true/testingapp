package com.example.testingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testingproject.adapters.RecyclerViewAdapter
import com.example.testingproject.databinding.ActivityMainBinding
import com.example.testingproject.helpers.textChanges
import com.example.testingproject.helpers.upper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val tempResults = listOf(Result(1, "Nike"), Result(2, "Nide"),Result(3, "Force"))
    @Inject lateinit var recyclerViewAdapter: RecyclerViewAdapter

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerViewAdapter()
        setSearchInputListener()

    }

    fun setRecyclerViewAdapter() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerViewAdapter
        }
    }

    fun setSearchInputListener() {
        binding.searchInput.textChanges().debounce(300)
            .onEach { text ->
                val filteredList = tempResults.filter { text.isNotEmpty() && it.text.upper().contains(text.toString().upper()) }
                recyclerViewAdapter.setResults(filteredList)
            }
            .launchIn(lifecycleScope)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}