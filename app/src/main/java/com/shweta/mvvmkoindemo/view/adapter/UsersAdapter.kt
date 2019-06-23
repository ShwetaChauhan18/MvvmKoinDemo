package com.shweta.mvvmkoindemo.view.adapter

import android.view.View
import androidx.databinding.ViewDataBinding
import com.shweta.mvvmkoindemo.R
import com.shweta.mvvmkoindemo.model.Users

class UsersAdapter: BaseRecyclerAdapter<Users>() {

    override fun getLayoutIdForType(viewType: Int): Int = R.layout.list_item_users

    override fun getLayoutIdForLoading(viewType: Int): Int {
        return R.layout.item_loading
    }

    override fun onItemClick(view: View?, adapterPosition: Int) {
        when (view?.id) {
        }
    }

    override fun setDataForListItem(binding: ViewDataBinding, dataModel: Users) {

    }

    override fun areItemsSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id
    }
}