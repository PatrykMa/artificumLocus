package com.example.artificumlocus.models.utilites

import android.content.Context
import com.example.artificumlocus.models.ViewModelFactorys.OffersViewModelFactory

object InjectorUtils {


    fun provideOfferListViewModelFactory(context: Context): OffersViewModelFactory {
        return OffersViewModelFactory()
    }
}