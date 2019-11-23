package com.example.artificumlocus.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.artificumlocus.databinding.FragmentGroupChatBinding
import com.example.artificumlocus.databinding.FragmentOffertListBinding
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.models.GroupChatViewModel
import com.example.artificumlocus.models.models.OfferListViewModel
import com.example.artificumlocus.models.utilites.InjectorUtils
import com.example.artificumlocus.services.MyIdProvider
import com.example.artificumlocus.views.adapters.GroupChatAdapter
import com.example.artificumlocus.views.adapters.OfferAdapter

class GroupChatFragment : Fragment() {
    private val viewModel: GroupChatViewModel by viewModels {
        InjectorUtils.provideGroupChatViewModelFactory(requireContext())
    }
    lateinit var binding : FragmentGroupChatBinding
    private var checkScrollingUp = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGroupChatBinding.inflate(inflater, container, false)
        context ?: return binding.root


        val adapter = GroupChatAdapter(MyIdProvider.id)
        binding.rercycleViewGruopChats.adapter = adapter
        subscribeUi(adapter)

        viewModel.update(MyIdProvider.id)

        return binding.root
    }



    private fun subscribeUi(adapter: GroupChatAdapter) {
        viewModel.groupChat.observe(viewLifecycleOwner) { groupChat ->
            if (groupChat != null) {
                adapter.submitList(groupChat)
            }

        }

    }


}
