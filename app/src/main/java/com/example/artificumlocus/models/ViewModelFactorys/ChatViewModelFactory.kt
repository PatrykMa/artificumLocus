package com.example.artificumlocus.models.ViewModelFactorys

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.artificumlocus.models.models.ChatViewModel
import com.example.artificumlocus.models.models.DetailedOfferViewModel
import com.example.artificumlocus.services.OffersProvider

class ChatViewModelFactory (var context: Context): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChatViewModel(OffersProvider(context)) as T
    }
}