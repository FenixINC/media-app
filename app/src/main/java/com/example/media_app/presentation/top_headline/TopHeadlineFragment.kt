package com.example.media_app.presentation.top_headline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.media_app.R
import com.example.media_app.data.entity.ResultState
import com.example.media_app.data.entity.TopHeadline
import com.example.media_app.data.implementation.TopHeadlineRepositoryImpl
import com.example.media_app.databinding.FragmentTopHeadlineBinding
import kotlinx.coroutines.CoroutineScope

class TopHeadlineFragment : Fragment() {

    private lateinit var mBinding: FragmentTopHeadlineBinding
    //    private lateinit var mAdapter: TvShowAdapter
//    private val mViewModel by viewModels<TopHeadlineViewModel> {
//        TopHeadlineViewModel.Factory(TopHeadlineRepositoryImpl())
//    }
    private lateinit var mViewModel: TopHeadlineViewModel

    companion object {
        fun newInstance() = TopHeadlineFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this@TopHeadlineFragment,
                TopHeadlineViewModel.Factory(TopHeadlineRepositoryImpl()))
                .get(TopHeadlineViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentTopHeadlineBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.header_top_headline)

        lifecycleScope.launchWhenStarted {
            doLoadTvShowList(scope = this)
        }
    }

    private fun doLoadTvShowList(scope: CoroutineScope) {
        mViewModel.loadTopHeadlineList(scope)?.observe(this@TopHeadlineFragment, Observer { result ->
            result?.let {
                handleResult(result)
            }
        })
    }

    private fun handleResult(result: ResultState<TopHeadline>) {
        when (result) {
//            is ResultState.Loading -> updateViewState(true)
//            is ResultState.Failure -> updateViewState(false)
//            is ResultState.Error -> updateViewState(false)
//            is ResultState.Success -> {
//                mAdapter.setList(result.data)
//                updateViewState(false)
//            }
        }
    }
}