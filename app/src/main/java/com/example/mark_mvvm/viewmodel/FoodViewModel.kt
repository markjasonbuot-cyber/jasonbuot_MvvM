package com.example.mark_mvvm.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mark_mvvm.R
import com.example.mark_mvvm.model.Food

class FoodViewModel : ViewModel() {

    val foods = mutableStateOf(
        listOf(
            Food("Fried Chicken", "₱35", imageRes = R.drawable.friedchicken),
            Food("Palabok", "₱230", imageRes = R.drawable.palabok),
            Food("Siomai", "₱25", imageRes = R.drawable.siomai),
            Food("Coke", "₱50", imageRes = R.drawable.coke),
            Food("kwekkwek", "₱25", imageRes = R.drawable.kwekkwek),
            Food("sundae", "₱40", imageRes = R.drawable.sundae),

        )
    )
}
