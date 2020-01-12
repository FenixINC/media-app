package com.example.media_app.presentation.top_headline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.media_app.BR
import com.example.media_app.R
import com.example.media_app.data.entity.Article
import com.example.media_app.data.entity.ResultState
import com.example.media_app.data.entity.TopHeadline
import com.example.media_app.data.implementation.TopHeadlineRepositoryImpl
import com.example.media_app.databinding.FragmentTopHeadlineBinding
import kotlinx.coroutines.CoroutineScope

class TopHeadlineFragment : Fragment(), TopHeadlineListener {

    private lateinit var mBinding: FragmentTopHeadlineBinding
    //    private val mViewModel by viewModels<TopHeadlineViewModel> { TopHeadlineViewModel.Factory(TopHeadlineRepositoryImpl()) }
    private lateinit var mViewModel: TopHeadlineViewModel
    private lateinit var mAdapter: TopHeadlineAdapter

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

        setAdapter()

        lifecycleScope.launchWhenStarted {
            doLoadTvShowList(scope = this)
        }

        mBinding.swipeRefresh.setOnRefreshListener {
            lifecycleScope.launchWhenStarted {
                doLoadTvShowList(scope = this)
            }
        }
    }

    private fun setAdapter() {
        mAdapter = TopHeadlineAdapter(this)
        val rv = mBinding.recyclerView
        rv.layoutManager = LinearLayoutManager(activity)
        rv.setHasFixedSize(true)
        rv.adapter = mAdapter
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
            is ResultState.Loading -> updateViewState(true)
            is ResultState.Failure -> updateViewState(false)
            is ResultState.Error -> updateViewState(false)
            is ResultState.Success -> {
                mAdapter.setList(result.data.articles)
                updateViewState(false)
            }
        }
    }

    private fun updateViewState(showProgress: Boolean) {
        mBinding.showProgress = showProgress
        mBinding.swipeRefresh.isRefreshing = false
        mBinding.swipeRefresh.isEnabled = false
        if (showProgress) mBinding.isEmpty = false
        if (!showProgress) {
            mBinding.isEmpty = mAdapter.getList().isEmpty()
            mBinding.swipeRefresh.isEnabled = true
        }
    }

    override fun onItemClick(article: Article) {
//        if (!TextUtils.isEmpty(url)) {
//            if (!url.startsWith("http://") && !url.startsWith("https://")) {
//                CustomTabsIntent.Builder().build().launchUrl(activity, Uri.parse("http://$url"))
//            } else {
//                CustomTabsIntent.Builder().build().launchUrl(activity, Uri.parse(url))
//            }
//        } else {
//            Timber.d("Empty url")
//        }
    }

    private class TopHeadlineAdapter(listener: TopHeadlineListener) : RecyclerView.Adapter<TopHeadlineAdapter.ViewHolder>() {

        private val mListener: TopHeadlineListener = listener
        private val mList: ArrayList<Article> = arrayListOf()

        fun setList(list: List<Article>) {
            mList.clear()
            mList.addAll(list)
            notifyDataSetChanged()
        }

        fun getItem(position: Int): Article = mList[position]

        fun getList(): List<Article> = mList

        override fun getItemCount(): Int = mList.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val holder: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.item_article, parent, false)
            return ViewHolder(holder)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(getItem(position), mListener)
        }

        private class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(data: Any, listener: TopHeadlineListener) {
                binding.setVariable(BR.model, data)
                binding.setVariable(BR.clickListener, listener)
            }
        }
    }
}