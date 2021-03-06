package com.example.artificumlocus.views

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.artificumlocus.R

import kotlinx.android.synthetic.main.activity_serch.*

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import com.example.artificumlocus.databinding.ActivitySerchBinding
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.models.OfferListViewModel
import com.example.artificumlocus.models.utilites.InjectorUtils
import com.example.artificumlocus.views.adapters.OfferAdapter
import androidx.navigation.findNavController


class SearchActivity : AppCompatActivity() {
    private val viewModel: OfferListViewModel by viewModels {
        InjectorUtils.provideOfferListViewModelFactory(this)
    }
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySerchBinding>(this, R.layout.activity_serch)
        binding.rvToDoList
        val adapter = OfferAdapter()
        binding.rvToDoList.adapter = adapter
        viewModel.offers.observe(this) { offers ->
            if (offers != null) {
                adapter.submitList(offers)
            }

        }

        viewModel.update(Address())
        //navController = findNavController(R.id.mainSpace_nav_fragment)

    }

}
