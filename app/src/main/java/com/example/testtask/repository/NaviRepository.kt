package com.example.testtask.repository

import com.example.testtask.fragments.CalculatedFragment
import com.example.testtask.fragments.LoginFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object NaviRepository {
    fun login() = FragmentScreen { LoginFragment() }
    fun calculation() = FragmentScreen { CalculatedFragment() }
}