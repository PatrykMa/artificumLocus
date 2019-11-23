package com.example.artificumlocus.models.utilites

import android.content.Context
import com.example.artificumlocus.models.ViewModelFactorys.ChatViewModelFactory
import com.example.artificumlocus.models.ViewModelFactorys.DetailedOfferViewModelFactory
import com.example.artificumlocus.models.ViewModelFactorys.OffersViewModelFactory

object InjectorUtils {


    fun provideOfferListViewModelFactory(context: Context): OffersViewModelFactory {
        return OffersViewModelFactory(context)
    }
    fun provideDetailedOfferViewModelFactory(context: Context): DetailedOfferViewModelFactory {
        return DetailedOfferViewModelFactory(context)
    }
    fun provideChatViewModelFactory(context: Context): ChatViewModelFactory {
        return ChatViewModelFactory(context)
    }
}