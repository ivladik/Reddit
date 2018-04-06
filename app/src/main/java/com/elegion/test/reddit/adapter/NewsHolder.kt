package com.elegion.test.reddit.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.elegion.test.reddit.R
import com.elegion.test.reddit.R.id.*
import com.elegion.test.reddit.extensions.getFriendlyTime
import com.elegion.test.reddit.extensions.loadImg
import com.elegion.test.reddit.model.RedditNewsItem
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by Vladislav Falzan.
 */
class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: RedditNewsItem) = with(itemView) {
        img_thumbnail.loadImg(item.thumbnail)
        description.text = item.title
        author.text = item.author
        comments.text = "${item.numComments} comments"
        time.text = item.created.getFriendlyTime()
    }
}