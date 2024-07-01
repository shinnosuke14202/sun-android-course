package com.example.suncourse.fragment_lifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.suncourse.R
import com.example.suncourse.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val binding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    var onClick : () -> Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val title = arguments?.getString("title").toString()

        binding.apply {
            tvName.text = title
            btnBack?.setOnClickListener {
                onClick.invoke()
            }
        }

        return binding.root
    }


    companion object {

        fun newInstance(onClick : () -> Unit) = DetailFragment().apply {
            this.onClick = onClick
        }
    }

}