package com.example.artificumlocus.models.models

import androidx.lifecycle.ViewModel
import com.example.artificumlocus.services.OffersProvider

class DetailedOfferViewModel internal constructor(val provider: OffersProvider) : ViewModel() {

    var offer = provider.offer
    fun setID(id:Int){
        provider.getByID(id)
    }
}

