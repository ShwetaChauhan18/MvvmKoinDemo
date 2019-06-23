package com.shweta.mvvmkoindemo.view.fragment

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration

import com.shweta.mvvmkoindemo.R
import com.shweta.mvvmkoindemo.base.BaseFragment
import com.shweta.mvvmkoindemo.databinding.FragmentTab1Binding
import com.shweta.mvvmkoindemo.view.adapter.UsersAdapter
import com.shweta.mvvmkoindemo.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_tab1.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class Tab1Fragment : BaseFragment<FragmentTab1Binding,MainActivityViewModel>() {

    private lateinit var mUsersAdapter: UsersAdapter

    override val mViewModel: MainActivityViewModel by sharedViewModel()

    override fun getLayoutResId(): Int = R.layout.fragment_tab1

    override fun init() {
        bindingObject?.clickHandler = this
        setRecyclerView()
        mViewModel.callGithubApi()
    }

    override fun initializeObservers() {
        /*mViewModel.allUserssListLiveData.watch(this) {
            when (it.status) {
                BaseViewModel.Status.LOADING -> {

                }
                BaseViewModel.Status.SUCCESS -> {

                }
                BaseViewModel.Status.ERROR -> {
                   // toast(it.throwable?.message.toString())
                }
            }
        }*/
    }

    override fun onClick(view: View?) {
        when(view?.id){

        }
    }

    private fun setRecyclerView() {
        mUsersAdapter = UsersAdapter()
        val itemDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL)
        ContextCompat.getDrawable(requireContext(), R.color.colorBackground)?.let { itemDecorator.setDrawable(it) }
        recylerView.addItemDecoration(itemDecorator)
        recylerView.adapter = mUsersAdapter
    }
}
