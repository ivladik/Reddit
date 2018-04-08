package com.elegion.test.reddit.news

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elegion.test.reddit.BaseFragment
import com.elegion.test.reddit.R
import com.elegion.test.reddit.news.adapter.NewsAdapter
import com.elegion.test.reddit.extensions.inflate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.news_fragment.*

/**
 * Created by Vladislav Falzan.
 */
class NewsFragment : BaseFragment() {

    private val mNewsManager by lazy { // todo: why not: NewsManager()
        NewsManager()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }
    }

    private fun requestNews() {
        val disposable = mNewsManager.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { news ->
                            (news_list.adapter as NewsAdapter).addNews(news)
                        },
                        { error ->
                            Snackbar.make(
                                    news_list,
                                    error.message ?: "",
                                    Snackbar.LENGTH_LONG
                            )
                                    .show()
                        }
                )
        mCompositeDisposable.add(disposable)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}