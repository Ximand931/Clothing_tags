package com.happs.ximand.clothingtags.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.happs.ximand.clothingtags.BR
import com.happs.ximand.clothingtags.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VM : BaseViewModel, B : ViewDataBinding>(
    private val layoutResId: Int, private val menuResId: Int
) : Fragment() {

    protected var viewModel: VM? = null
        get() {
            if (field != null) {
                return field
            } else {
                throw IllegalStateException(
                    "ViewModel was not initialized. It will " +
                            "initialize after onCreate method"
                )
            }
        }
        private set

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(menuResId, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return viewModel?.notifyOptionsMenuItemClicked(item.itemId) ?: false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setHasOptionsMenu(true)
        viewModel = ViewModelProvider(
            this, SavedStateViewModelFactory(activity?.application!!, this)
        ).get(getViewModelGenericClass())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<B>(inflater, layoutResId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        onViewDataBindingCreated(binding)

        onPreViewModelAttached(viewModel!!)
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
        return binding.root
    }

    fun getDefaultTag(): String {
        return javaClass.simpleName
    }

    protected open fun onPreViewModelAttached(viewModel: VM) {

    }

    protected open fun onViewDataBindingCreated(binding: B) {

    }

    open fun onExternalEvent(eventId: Int) {

    }

    protected fun setActionBarTitle(resId: Int) {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setTitle(resId)
    }

    protected fun setActionBar(string: String) {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = string
    }

    @Suppress("UNCHECKED_CAST")
    fun getViewModelGenericClass(): Class<VM> {
        return (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VM>
    }
}