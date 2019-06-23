package com.shweta.mvvmkoindemo.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(private val fm: FragmentManager, private val fragments: ArrayList<Pair<String, Fragment>>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragments[position].second
    }

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int): CharSequence? {
        return fragments[position].first
    }

    override fun getItemPosition(any: Any): Int {
        return 0
    }
}