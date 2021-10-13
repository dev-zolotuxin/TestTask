package com.example.testtask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.testtask.R
import com.github.terrakok.cicerone.Router
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_calculated.*
import org.koin.android.ext.android.inject

class CalculatedFragment : Fragment() {

    private val router by inject<Router>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculated, container, false)
    }

    override fun onStart() {
        super.onStart()
        requireActivity().apply {
            tvTitle.text = "Вычисление"
            imgBack.isVisible = true
            imgBack?.setOnClickListener {
                router.exit()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        btnCalculate.setOnClickListener {
            kotlin.runCatching {
                when (spOperationSymbol.selectedItemPosition){
                    0 ->  ResultText.text = "${firstNumberEdit.text.toString().trim().toLong() + secondNumberEdit.text.toString().trim().toLong()}"
                    1 ->  ResultText.text = "${firstNumberEdit.text.toString().trim().toLong() - secondNumberEdit.text.toString().trim().toLong()}"
                    2 ->  ResultText.text = "${firstNumberEdit.text.toString().trim().toLong() * secondNumberEdit.text.toString().trim().toLong()}"
                    3 ->  ResultText.text = "${firstNumberEdit.text.toString().trim().toLong() / secondNumberEdit.text.toString().trim().toLong()}"
                }
            }.onFailure {
                Toast.makeText(requireContext(), "Неправильный ввод чисел", Toast.LENGTH_SHORT).show()
            }

        }
    }

}