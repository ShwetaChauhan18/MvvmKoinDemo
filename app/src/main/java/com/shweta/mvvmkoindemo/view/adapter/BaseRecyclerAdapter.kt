package com.shweta.mvvmkoindemo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shweta.mvvmkoindemo.BR

abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<BaseRecyclerAdapter<T>.RecyclerHolder>(){

    protected val arrayList = ArrayList<T>()
    var previousArrayList = arrayListOf<T>()
    private val itemTypeNormal = 1
    private val itemTypeLoader = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerAdapter<T>.RecyclerHolder {
        val binding: ViewDataBinding = if (viewType == itemTypeNormal) {
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), getLayoutIdForType(viewType), parent, false)
        } else {
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), getLayoutIdForLoading(viewType), parent, false)
        }
        return RecyclerHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isItemLoading(position)) {
            itemTypeLoader
        } else {
            itemTypeNormal
        }
    }

    override fun onBindViewHolder(holder: BaseRecyclerAdapter<T>.RecyclerHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    /**
     * get view type for adapter
     */
    abstract fun getLayoutIdForType(viewType: Int): Int

    /**
     * get layout for loader.
     * @param viewType Int
     * @return Int
     */
    open fun getLayoutIdForLoading(viewType: Int): Int {
        return 0
    }

    /**
     * This is abstract function used to get item click for all the adapter views
     */
    abstract fun onItemClick(view: View?, adapterPosition: Int)

    /**
     * This is abstract function used to get set data for recycler list items.
     */
    abstract fun setDataForListItem(binding: ViewDataBinding, dataModel: T)

    /**
     * inner class used to set recycler view holder.
     */
    inner class RecyclerHolder(private val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {
        /**
         * bind data
         */
        fun bind(dataModel: T) {
            viewDataBinding.setVariable(BR.dataModel, dataModel)
            viewDataBinding.setVariable(BR.clickHandler, this)
            setDataForListItem(viewDataBinding, dataModel)
            viewDataBinding.executePendingBindings()
        }

        override fun onClick(v: View?) {
            onItemClick(v, adapterPosition)
        }
    }

    fun setList(newList: ArrayList<T>) {
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtil(arrayList, newList))
        if (arrayList.size >= previousArrayList.size) {
            previousArrayList = arrayList.clone() as ArrayList<T>
        }
        arrayList.clear()
        arrayList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun clearList() {
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtil(arrayList, ArrayList()))
        arrayList.clear()
        arrayList.addAll(ArrayList())
        diffResult.dispatchUpdatesTo(this)
    }

    inner class BaseDiffUtil(private val oldList: ArrayList<T>, private val newList: ArrayList<T>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return areItemsSame(oldList[oldItemPosition], newList[newItemPosition])
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

    abstract fun areItemsSame(oldItem: T, newItem: T): Boolean

    protected open fun getLoaderItem(): T? {
        return null
    }

    fun addLoader() {
        if (!isLoading()) {
            val newList = ArrayList<T>(arrayList)
            getLoaderItem()?.let { newList.add(it) }
            setList(newList)
        }
    }

    fun removeLoader() {
        if (isLoading()) {
            if (!arrayList.isEmpty()) {
                val newList = ArrayList<T>(arrayList)
                newList.remove(getLoaderItem())
                setList(newList)
            }
        }
    }

    internal fun isLoading(): Boolean {
        return arrayList.isEmpty() || isLastItemLoading()
    }

    open fun isLastItemLoading(): Boolean {
        return false
    }

    open fun isItemLoading(position: Int): Boolean {
        return false
    }
}