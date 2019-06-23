package com.shweta.mvvmkoindemo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shweta.mvvmkoindemo.R
import com.shweta.mvvmkoindemo.base.BaseFragment
import com.shweta.mvvmkoindemo.databinding.FragmentTab2Binding
import com.shweta.mvvmkoindemo.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class Tab2Fragment : BaseFragment<FragmentTab2Binding,MainActivityViewModel>() {
    override val mViewModel: MainActivityViewModel by sharedViewModel()

    override fun getLayoutResId(): Int = R.layout.fragment_tab2

    override fun init() {
    }

    override fun initializeObservers() {

    }

    override fun onClick(view: View?) {
        when(view?.id){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }
}
