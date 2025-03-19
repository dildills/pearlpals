import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SkincareScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Rekomendasi Produk Skincare", fontSize = 20.sp)

        val skincareItems = listOf(
            "Skintific Hyaluronic",
            "Glad2Glow Toner",
            "Cosrx Snail Mucin",
            "Laneige Cream Skin",
            "Scarlett Serum",
            "Anessa Sunscreen"
        )

        skincareItems.forEach { item ->
            Text(text = item, modifier = Modifier.padding(8.dp))
        }
    }
}