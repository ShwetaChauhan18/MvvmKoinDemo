package com.shweta.mvvmkoindemo.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.shweta.mvvmkoindemo.BR

abstract class BaseActivity<Binding : ViewDataBinding, ViewModel : BaseViewModel> : AppCompatActivity(),
    View.OnClickListener {
    protected lateinit var bindObject: Binding
    protected abstract val mViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performViewModelBinding()
        initializeObservers()

    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun init()

    abstract fun initializeObservers()

    private fun performViewModelBinding() {
        bindObject = DataBindingUtil.setContentView(this, getLayoutResId())
        bindObject.lifecycleOwner = this
        bindObject.setVariable(BR.viewModel, mViewModel)
        bindObject.executePendingBindings()
        init()

    }
}