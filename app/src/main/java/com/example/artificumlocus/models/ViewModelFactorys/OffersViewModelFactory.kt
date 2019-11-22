package com.example.artificumlocus.models.ViewModelFactorys

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.artificumlocus.models.models.OfferListViewModel

class OffersViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OfferListViewModel() as T
    }
}