package com.example.artificumlocus.models.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.data.Offer
import com.example.artificumlocus.services.OffersProvider
import java.util.*

class OfferListViewModel internal constructor(val provider:OffersProvider) :ViewModel() {


    private fun t(data:List<Offer>) = data
    private val _offer: MutableLiveData<List<Offer>> = MutableLiveData<List<Offer>>()
    val offers: LiveData<List<Offer>> = provider.offers
    fun update(address: Address){
        provider.update(address)
    }

}