package com.example.artificumlocus.models.ViewModelFactorys

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.artificumlocus.models.models.OfferListViewModel
import com.example.artificumlocus.services.OffersProvider

class OffersViewModelFactory (var context: Context): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OfferListViewModel(OffersProvider(context)) as T
    }
}