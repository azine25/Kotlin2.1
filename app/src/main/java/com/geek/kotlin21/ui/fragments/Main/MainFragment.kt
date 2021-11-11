package com.geek.kotlin21.ui.fragments.Main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.geek.kotlin21.R
import com.geek.kotlin21.data.objects.Constants
import com.geek.kotlin21.databinding.FragmentMainBinding
import com.google.android.material.slider.Slider

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<MainFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setQuestionsAmount()
        setCategories()
        setDifficulty()
        getQuestions()
    }

    private fun setQuestionsAmount() {
        binding.score.text = binding.questionsCountSlider.value.toInt().toString()
        binding.questionsCountSlider.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
            viewModel.setQuestionsAmount(slider.value.toInt())
            viewModel.getQuestionsAmount().observe(viewLifecycleOwner) {
                binding.score.text = value.toInt().toString()
            }
        })
    }

    private fun setCategories() {
        viewModel.getCategories().observe(requireActivity()) { response ->
            val list = arrayListOf<String>()
            list.addAll(Constants.CATEGORIES)
            response.trivia_categories.forEach {
                list.add(it.name!!)
            }
            binding.categorySpinner.adapter =
                ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_dropdown_item_1line,
                    list
                )
        }
    }

    private fun setDifficulty() {
        binding.difficultySpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            Constants.DIFFICULTY
        )
    }

    private fun getQuestions() {

    }
}