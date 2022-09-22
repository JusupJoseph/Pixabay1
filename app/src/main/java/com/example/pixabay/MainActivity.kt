package com.example.pixabay

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pixabay.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var adapter = PixabayAdapter(mutableListOf())
    var page = 1
    var perPage = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnStartSearching.setOnClickListener {
                doRequest()
            }
            btnChangeWord.setOnClickListener {
                ++page
                doRequest()
            }
            btnAddWord.setOnClickListener {
                perPage += 10
                doRequest()
            }
        }
    }

    private fun doRequest() {
        App.api.getImages(binding.etSearchingWord.text.toString(), page = page, perPage = perPage).enqueue(object :
            Callback<PixabayModel> {
            override fun onResponse(
                call: Call<PixabayModel>,
                response: Response<PixabayModel>
            ) {
                if (response.isSuccessful) {
                    adapter = PixabayAdapter(response.body()!!.hits)
                    binding.recyclerWord.adapter = adapter
                }
            }

            override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Ой что то пошло не так!\n Повторите попытку позже",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }
}