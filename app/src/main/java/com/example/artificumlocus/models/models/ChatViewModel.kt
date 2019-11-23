package com.example.artificumlocus.models.models

import androidx.lifecycle.ViewModel
import com.example.artificumlocus.services.OffersProvider

class ChatViewModel internal constructor(val provider: OffersProvider) : ViewModel() {

    var chat = provider.chats
    fun setUsersId(firstId:Int,secId:Int){
        provider.getUsersChat(firstId,secId)
    }
}