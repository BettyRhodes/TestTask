package com.example.testtask.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class Navigator(
    activity: FragmentActivity,
    fragmentManager: FragmentManager,
    containerId: Int
): SupportAppNavigator(activity, fragmentManager, containerId)