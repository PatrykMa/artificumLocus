package com.example.artificumlocus.services

import android.content.Context
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.artificumlocus.R
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.data.Offer

class OffersProvider(val context: Context) {
    private var offerList = listOf<Offer>(
        Offer().apply { title = "tytuł1";price = 153; bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.apple)},
        Offer().apply { title = "tytuł2";price = 196; bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.apple)}
    )
    private val _offer: MutableLiveData<List<Offer>> = MutableLiveData<List<Offer>>()
    val offers: LiveData<List<Offer>> = _offer

    fun update(address: Address){
        _offer.postValue(offerList)
    }
}