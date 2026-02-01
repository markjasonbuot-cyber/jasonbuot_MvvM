package com.example.mark_mvvm.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mark_mvvm.model.Food
import com.example.mark_mvvm.ui.theme.Mark_MvvmTheme
import com.example.mark_mvvm.viewmodel.FoodViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Mark_MvvmTheme{
                FoodScreen(viewModel = FoodViewModel())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodScreen(viewModel: FoodViewModel) {

    val foods = viewModel.foods.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Food Items") }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(foods) { food ->
                FoodItem(food)
            }
        }
    }
}

@Composable
fun FoodItem(food: Food) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = food.imageRes),
                contentDescription = "Food Image",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
        }
        Column {
            Text(text = food.name, style = MaterialTheme.typography.titleMedium)
            Text(text = food.price, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
