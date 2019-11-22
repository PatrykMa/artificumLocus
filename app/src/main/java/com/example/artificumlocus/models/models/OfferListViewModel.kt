package com.example.artificumlocus.models.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artificumlocus.models.data.Offer
import java.util.*

class OfferListViewModel internal constructor() :ViewModel() {

    private val _offer: MutableLiveData<List<Offer>> = MutableLiveData<List<Offer>>()
    val offers: LiveData<List<Offer>> = _offer

}