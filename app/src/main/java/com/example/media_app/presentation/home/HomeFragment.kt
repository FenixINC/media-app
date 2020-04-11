package com.example.media_app.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.media_app.R
import com.example.media_app.databinding.FragmentHomeBinding
import com.example.media_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.serialization.ImplicitReflectionSerializer
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var characterAdapter: CharactersAdapter

    override val viewModel by inject<HomeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_home

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @ImplicitReflectionSerializer
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel

        setAdapter()

        viewModel.ktorLoadAllCharacters()
//        viewModel.loadAllCharacters()
        viewModel.characterLiveData.observe(viewLifecycleOwner, Observer {
            it?.data?.let { list ->
                characterAdapter.characterList = list.toMutableList()
            }
        })
    }

    private fun setAdapter() {
        characterAdapter = CharactersAdapter {}
        recycler_view.layoutManager = GridLayoutManager(activity, 1)
        recycler_view.adapter = characterAdapter
    }
}