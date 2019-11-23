package com.example.artificumlocus.services

import android.content.Context
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.artificumlocus.R
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.data.Offer

class OffersProvider(val context: Context) {
    private val _address = Address().apply { state= "śląskie";cityName="Gliwice"; street = "toszewska" }
    private val _content = "bardzo długi opis  z wieloma zagadnieniami i zdaniami współdzielnie złozonymi lorem ipsum etn nocet titus in provincja habiatat procul a roma titus incola privincjia est"
    private var offerList = listOf<Offer>(
        Offer().apply { description = _content;address = _address; id =1;title = "tytuł1";price = 153; bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.apple)},
        Offer().apply { description = _content;address = _address; id =2;title = "tytuł2";price = 196; bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.apple)}
    )
    private val _offers: MutableLiveData<List<Offer>> = MutableLiveData<List<Offer>>()
    private val _offer: MutableLiveData<Offer> = MutableLiveData<Offer>()
    val offers: LiveData<List<Offer>> = _offers
    val offer:LiveData<Offer> = _offer

    fun update(address: Address){
        _offers.postValue(offerList)
    }
    fun getByID(id:Int){
        offerList.forEach {
            if(it.id == id){
                _offer.postValue(it)
            }
        }
    }
}