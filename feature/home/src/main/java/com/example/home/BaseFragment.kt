package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigator.NavigationManager
import javax.inject.Inject
import javax.inject.Singleton

abstract class BaseFragment : Fragment() {

    @Inject
    @Singleton
    lateinit var navigator: NavigationManager

    abstract fun bindView(inflater: LayoutInflater, container: ViewGroup?): View?

    abstract fun setupUI()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return bindView(inflater, container)
    }
}
