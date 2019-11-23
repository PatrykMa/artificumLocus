package com.example.artificumlocus.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.artificumlocus.R
import com.example.artificumlocus.databinding.FragmentAddOffertBinding
import com.example.artificumlocus.databinding.FragmentChatBinding
import com.example.artificumlocus.models.models.ChatViewModel
import com.example.artificumlocus.models.utilites.InjectorUtils
import com.example.artificumlocus.services.MyIdProvider
import com.example.artificumlocus.views.adapters.MessageAdapter
import com.example.artificumlocus.views.adapters.OfferAdapter

class ChatFragment : Fragment() {
    private val args: ChatFragmentArgs by navArgs()
    private val viewModel: ChatViewModel by viewModels {
        InjectorUtils.provideChatViewModelFactory(requireContext())
    }
    lateinit var binding : FragmentChatBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChatBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = MessageAdapter(MyIdProvider.id)
        binding.recycleDeparture.adapter = adapter
        subscribeUi(adapter)
        viewModel.setUsersId(args.myId,args.otherId)

        return binding.root
    }


    private fun subscribeUi(adapter: MessageAdapter) {
        viewModel.chat.observe(viewLifecycleOwner) { chat ->
            /**
             *  Plant may return null, but the [observe] extension function assumes it will not be null.
             *  So there will be a warning（Condition `departures != null` is always `true`） here.
             *  I am not sure if the database return data type should be defined as nullable, Such as `LiveData<List<Plant>?>` .
             */
            if (chat != null) {
                adapter.submitList(chat)
            }

            }

        }
}