package com.example.artificumlocus.services

import android.content.Context
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.artificumlocus.R
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.data.Message
import com.example.artificumlocus.models.data.Offer
import com.example.artificumlocus.models.data.User

class OffersProvider(val context: Context) {
    var bit = BitmapFactory.decodeResource(context.resources, R.drawable.apple)
    private val _address = Address().apply { state= "śląskie";cityName="Gliwice"; street = "toszewska" }
    private val _content = "bardzo długi opis  z wieloma zagadnieniami i zdaniami współdzielnie złozonymi lorem ipsum etn nocet titus in provincja habiatat procul a roma titus incola privincjia est"
    private var offerList = listOf<Offer>(
        Offer().apply { description = _content;address = _address; id =1;title = "tytuł1";price = 153; bitmap = bit},
        Offer().apply { description = _content;address = _address; id =2;title = "tytuł2";price = 196; bitmap = bit}
    )

    private val chatGroupList = listOf<Pair<Offer,User>>(Pair(Offer().apply { description = _content;address = _address; id =1;title = "tytuł1";price = 153; bitmap = bit},
        User().apply { nick = "gieniek" }))

    private var chatList = listOf<Message>(Message().apply { fromUserId = 0; toUserId = 1; content = "dzień Dybry" },
    Message().apply { fromUserId = 1; toUserId = 0; content = "dzień Dybry" },
        Message().apply { fromUserId = 0; toUserId = 1; content = "są jeszcze" },
        Message().apply { fromUserId = 1; toUserId = 0; content = "nie" })
    private val _offers: MutableLiveData<List<Offer>> = MutableLiveData<List<Offer>>()
    private val _offer: MutableLiveData<Offer> = MutableLiveData<Offer>()
    private val _chat: MutableLiveData<List<Message>> = MutableLiveData<List<Message>>()
    private val _chatGroup: MutableLiveData<List<Pair<Offer,User>>> = MutableLiveData<List<Pair<Offer,User>>>()
    val offers: LiveData<List<Offer>> = _offers
    val offer:LiveData<Offer> = _offer
    val chats:LiveData<List<Message>> = _chat

    val groupChat :LiveData<List<Pair<Offer, User>>> = _chatGroup
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

    fun getUsersChat(fId:Int,sId:Int){
        _chat.postValue(chatList)
    }

    fun getConversation(myId:Int)
    {
        _chatGroup.postValue(chatGroupList)
    }
}