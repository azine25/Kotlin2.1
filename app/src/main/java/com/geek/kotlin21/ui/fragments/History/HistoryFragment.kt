package com.geek.kotlin21.ui.fragments.History

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geek.kotlin21.core.App
import com.geek.kotlin21.databinding.FragmentHistoryBinding
import com.geek.kotlin21.model.TriviaCategories
import com.geek.kotlin21.ui.fragments.MainViewModel
import retrofit2.Call
import retrofit2.Callback


class HistoryFragment : Fragment() {

    private var binding: FragmentHistoryBinding? = null
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding?.btnIncrement?.setOnClickListener {
            viewModel.setCount()
        }
    }

    private fun initObservers() {
        viewModel.getCount().observe(viewLifecycleOwner) {
            binding?.tvResult?.text = it.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
