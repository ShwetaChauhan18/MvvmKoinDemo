package com.shweta.mvvmkoindemo

import android.view.View
import androidx.fragment.app.Fragment
import com.shweta.mvvmkoindemo.base.BaseActivity
import com.shweta.mvvmkoindemo.databinding.ActivityMainBinding
import com.shweta.mvvmkoindemo.view.fragment.Tab1Fragment
import com.shweta.mvvmkoindemo.view.adapter.PagerAdapter
import com.shweta.mvvmkoindemo.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.scope.currentScope

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    private lateinit var mPagerAdapter: PagerAdapter

    override val mViewModel: MainActivityViewModel by currentScope.inject()

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun init() {
        bindObject.clickHandler = this

        mPagerAdapter = PagerAdapter(supportFragmentManager, getFragments())
        viewPager.adapter = mPagerAdapter
        bottomNavigation.selectedItemId = R.id.navigation_tab1
        bottomNavigationClick()
    }

    override fun initializeObservers() {
    }

    override fun onClick(view: View?) {
        when (view?.id) {

        }
    }

    private fun setToolbar() {

    }

    private fun getFragments(): ArrayList<Pair<String, Fragment>> {
        val fragmentList = ArrayList<Pair<String, Fragment>>()
        fragmentList.add(Pair("", Tab1Fragment()))
        fragmentList.add(Pair("", Tab1Fragment()))
        return fragmentList
    }

    private fun bottomNavigationClick() {
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_tab1 -> viewPager.currentItem = 0
                R.id.navigation_tab2 -> viewPager.currentItem = 1
            }
            true
        }
    }
}
