package com.example.artificumlocus.models.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.data.Offer
import com.example.artificumlocus.models.data.User
import com.example.artificumlocus.services.OffersProvider

class GroupChatViewModel  internal constructor(val provider: OffersProvider) : ViewModel() {

    val groupChat = provider.groupChat
    fun update(myID:Int){
        provider.getConversation(myID)
    }

}