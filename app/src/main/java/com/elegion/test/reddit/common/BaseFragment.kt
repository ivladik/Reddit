package com.elegion.test.reddit.common

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Vladislav Falzan.
 */
open class BaseFragment : Fragment() {

    protected var mCompositeDisposable = CompositeDisposable() // todo: why not lazy init?

    override fun onResume() {
        super.onResume()
        mCompositeDisposable = CompositeDisposable()
    }

    override fun onPause() {
        if (!mCompositeDisposable.isDisposed) {
            mCompositeDisposable.dispose()
        }
        mCompositeDisposable.clear()
        super.onPause()
    }
}