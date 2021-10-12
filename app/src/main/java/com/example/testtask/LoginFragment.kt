package com.example.testtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onResume() {
        super.onResume()
        val loginString = "admin"
        val passwordString = "123"
        activity?.title = "Авторизация"

        btnLogin.setOnClickListener {
            (activity as? MainActivity)?.hideKeyboard()

            if (loginEdit.text.toString() == loginString && passEdit.text.toString() == passwordString) {
                val ft = requireActivity().supportFragmentManager.beginTransaction()
                ft.addToBackStack(null)
                ft.replace(android.R.id.content, CalculatedFragment())
                ft.commit()
            } else
                Toast.makeText(requireContext(), "Неверный логин/пароль", Toast.LENGTH_SHORT)
                    .show()
        }

    }
}