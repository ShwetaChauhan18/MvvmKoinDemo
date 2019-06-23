package com.shweta.mvvmkoindemo.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.shweta.mvvmkoindemo.BR

abstract class BaseFragment<Binding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment(), View.OnClickListener {

    protected var bindingObject: Binding? = null
    protected abstract val mViewModel: ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingObject = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return bindingObject?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        performDataBinding()
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun init()

    abstract fun initializeObservers()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeObservers()
    }

    private fun performDataBinding() {
        bindingObject?.lifecycleOwner = this
        bindingObject?.setVariable(BR.viewModel, mViewModel)
        bindingObject?.executePendingBindings()

        init()
    }
}