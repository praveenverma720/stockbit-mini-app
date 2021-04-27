package com.didik.stockbitminiapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BindingFragment<V : ViewBinding> : Fragment() {

    private var _binding: V? = null
    protected val binding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderView()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): V

    abstract fun renderView()
}