package com.example.testtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_calculated.*

class CalculatedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculated, container, false)
    }

    override fun onResume() {
        super.onResume()
        activity?.title = "Вычисление"

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