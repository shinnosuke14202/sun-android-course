package com.example.suncourse.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.example.suncourse.R
import com.example.suncourse.databinding.FragmentFeedbackBinding


class FeedbackFragment : Fragment() {

    private val binding by lazy {
        FragmentFeedbackBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.apply {
            rgFeedback.setOnCheckedChangeListener { _, checkedId ->
                val userOption = view?.findViewById<RadioButton>(checkedId)?.text.toString()
                when (userOption) {
                    "Yes" -> tvArticle.text = "ARTICLE: Like."
                    "No" -> tvArticle.text = "ARTICLE: Thanks."
                }
            }
        }

        return binding.root
    }

}