package com.didik.feature_login.ui

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.didik.core.base.BindingFragment
import com.didik.core.router.FeatureRouter
import com.didik.feature_login.R
import com.didik.feature_login.databinding.FragmentLoginBinding

class LoginFragment : BindingFragment<FragmentLoginBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun renderView() {
        setupIconClickListener()
        setupButtonClickListener()
    }

    private fun setupIconClickListener() {
        binding.backIconImageView.setOnClickListener {
            showToast(getString(R.string.text_back))
        }

        binding.chatIconImageView.setOnClickListener {
            showToast(getString(R.string.text_chat))
        }
    }

    private fun setupButtonClickListener() {
        binding.loginGoogleButton.setOnClickListener {
            openWatchlist()
        }

        binding.loginFacebookButton.setOnClickListener {
            openWatchlist()
        }

        binding.loginButton.setOnClickListener {
            openWatchlist()
        }

        binding.loginWithFingerprintButton.setOnClickListener {
            openWatchlist()
        }

        binding.forgetPasswordButton.setOnClickListener {
            showToast(getString(R.string.text_forget_password))
        }

        binding.registerButton.setOnClickListener {
            showToast(getString(R.string.text_account_register))
        }
    }

    private fun openWatchlist() {
        val watchlistUri = Uri.parse(FeatureRouter.watchlist)
        findNavController().navigate(watchlistUri)
    }
}