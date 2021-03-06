package com.example.testtask.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.example.testtask.MainActivity
import com.example.testtask.R
import com.example.testtask.Settings
import com.example.testtask.repository.NaviRepository
import com.github.terrakok.cicerone.Router
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

    private val router by inject<Router>()

    private val settings by lazy {
        Settings(requireActivity())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginEdit.addTextChangedListener { text ->
            btnLogin.isEnabled = !text.isNullOrBlank() && passEdit.length() != 0
        }
        passEdit.addTextChangedListener { text ->
            btnLogin.isEnabled = !text.isNullOrBlank() && loginEdit.length() != 0
        }
    }

    override fun onStart() {
        super.onStart()
        requireActivity().apply {
            tvTitle.text = "Авторизация"
            imgBack.isVisible = false
        }
        rememberCheck.isChecked = settings.isCheckRemember
    }

    override fun onResume() {
        super.onResume()
        settings.login = "admin"
        settings.password = "123"

        if (rememberCheck.isChecked) {
            loginEdit.setText(settings.login)
            passEdit.setText(settings.password)
        }

        btnLogin.setOnClickListener {
            (activity as? MainActivity)?.hideKeyboard()
            if (loginEdit.text.toString() == settings.login  && passEdit.text.toString() == settings.password ) {
                settings.isCheckRemember = rememberCheck.isChecked
                router.navigateTo(NaviRepository.calculation())
            } else
                Toast.makeText(requireContext(), "Неверный логин/пароль", Toast.LENGTH_SHORT)
                    .show()
        }
    }
}