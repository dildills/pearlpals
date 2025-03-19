import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dilaproject.ui.theme.DilaProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DilaProjectTheme {
                PearlpalsApp()
            }
        }
    }
}

@Composable
fun PearlpalsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("skincare") { SkincareScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { navController.navigate("skincare") },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Go to Skincare")
            }

            Button(
                onClick = { navController.navigate("profile") },
                modifier = Modifier.padding(8.dp).align(Alignment.BottomCenter)
            ) {
                Text("Go to Profile")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkincareScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Skincare Screen")
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.padding(8.dp).align(Alignment.BottomCenter)
            ) {
                Text("Back to Home")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Profile Screen")
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.padding(8.dp).align(Alignment.BottomCenter)
            ) {
                Text("Back to Home")
            }
        }
    }
}