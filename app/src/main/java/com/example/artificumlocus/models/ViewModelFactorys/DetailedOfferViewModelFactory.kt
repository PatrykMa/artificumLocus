package com.example.artificumlocus.models.ViewModelFactorys

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.artificumlocus.models.models.DetailedOfferViewModel
import com.example.artificumlocus.models.models.OfferListViewModel
import com.example.artificumlocus.services.OffersProvider

class DetailedOfferViewModelFactory (var context: Context): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailedOfferViewModel(OffersProvider(context)) as T
    }
}