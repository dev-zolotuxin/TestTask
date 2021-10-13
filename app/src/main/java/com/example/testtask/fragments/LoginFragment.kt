package com.example.testtask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.testtask.MainActivity
import com.example.testtask.R
import com.example.testtask.repository.NaviRepository
import com.github.terrakok.cicerone.Router
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

    private val router by inject<Router>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onStart() {
        super.onStart()
        requireActivity().apply {
            tvTitle.text = "Авторизация"
            imgBack.isVisible = false
        }
    }

    override fun onResume() {
        super.onResume()
        val loginString = "admin"
        val passwordString = "123"

        btnLogin.setOnClickListener {
            (activity as? MainActivity)?.hideKeyboard()
            if (loginEdit.text.toString() == loginString && passEdit.text.toString() == passwordString) {
                router.navigateTo(NaviRepository.calculation())
            } else
                Toast.makeText(requireContext(), "Неверный логин/пароль", Toast.LENGTH_SHORT)
                    .show()
        }
    }
}