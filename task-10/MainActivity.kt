package com.example.kotlinpractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinpractice.ui.theme.KotlinPracticeTheme
import kotlin.random.Random

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KotlinPracticeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ShoppingCartScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    var nextProductId by remember {
        mutableIntStateOf(3)
    }

    val totalSum = products.sumOf { it.price }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Корзина",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        if (products.isEmpty()) {
            Text(text = "Корзина пуста")
        }

        products.forEach { product ->
            Text(
                text = "${product.name} — ${product.price} рублей",
                fontSize = 18.sp
            )
        }

        Text(
            text = "Товаров на сумму: $totalSum рублей",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val newProduct = Product(
                    id = nextProductId,
                    name = "Товар #${nextProductId + 1}",
                    price = Random.nextInt(0, 100)
                )

                val updatedProducts = products + newProduct

                products = updatedProducts
                nextProductId += 1

                if (updatedProducts.sumOf { it.price } > 500) {
                    Toast.makeText(
                        context,
                        "Доставка бесплатная!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text(text = "Добавить товар")
        }

        if (products.isNotEmpty()) {
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    products = products.dropLast(1)
                }
            ) {
                Text(text = "Удалить товар")
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
fun ShoppingCartPreview() {
    KotlinPracticeTheme {
        ShoppingCartScreen()
    }
}
