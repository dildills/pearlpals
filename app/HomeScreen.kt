import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pearlpals - Unlock Your Beauty", fontSize = 24.sp)

        Button(onClick = { navController.navigate("skincare") }) {
            Text("Skincare")
        }

        Button(onClick = { navController.navigate("profile") }) {
            Text("Profile")
        }
    }
}