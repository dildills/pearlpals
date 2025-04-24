package com.example.dilaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.dilaproject.ui.theme.DilaProjectTheme
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

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
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("PearlPals", fontWeight = FontWeight.Bold) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Unlock Your Beauty",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.navigate("skincare") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Skincare Routine", fontSize = 16.sp)
            }

            Button(
                onClick = { navController.navigate("profile") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("My Profile", fontSize = 16.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkincareScreen(navController: NavController) {
    val skincareItems = listOf(
        SkincareItem(
            name = "Cleansing Oil",
            description = "Membersihkan makeup dan kotoran pada wajah. Gunakan pada wajah kering dan pijat lembut sebelum dibilas.",
            imageRes = R.drawable.sonny11
        ),
        SkincareItem(
            name = "Facial Wash",
            description = "Membersihkan sisa minyak dan kotoran. Gunakan dengan air hangat dan pijat dengan gerakan melingkar.",
            imageRes = R.drawable.sonny11
        ),
        SkincareItem(
            name = "Toner",
            description = "Menyeimbangkan pH kulit dan menenangkan wajah. Aplikasikan dengan kapas atau tepuk langsung dengan telapak tangan.",
            imageRes = R.drawable.sonny11
        ),
        SkincareItem(
            name = "Essence",
            description = "Memberikan hidrasi awal dan membantu produk lain meresap lebih baik. Tepuk ringan hingga meresap.",
            imageRes = R.drawable.sonny11
        ),
        SkincareItem(
            name = "Serum",
            description = "Menargetkan masalah kulit spesifik seperti jerawat atau kerutan. Gunakan 2-3 tetes dan tepuk hingga meresap.",
            imageRes = R.drawable.sonny11
        ),
        SkincareItem(
            name = "Moisturizer",
            description = "Mengunci kelembapan dan nutrisi pada kulit. Oleskan dengan gerakan ke atas dan ke luar pada wajah dan leher.",
            imageRes = R.drawable.sonny11
        ),
        SkincareItem(
            name = "Sunscreen",
            description = "Melindungi kulit dari sinar UV. Aplikasikan setiap pagi dan ulangi setiap 2-3 jam jika beraktivitas di luar.",
            imageRes = R.drawable.sonny11
        ),
        SkincareItem(
            name = "Lip Balm",
            description = "Menjaga bibir tetap lembab dan mencegah kekeringan. Gunakan secara rutin terutama sebelum tidur.",
            imageRes = R.drawable.sonny11
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Skincare Routine") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Daily Skincare Steps",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                color = MaterialTheme.colorScheme.primary
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(skincareItems) { item ->
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateContentSize(),
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                        ) {
                            Image(
                                painter = painterResource(id = item.imageRes),
                                contentDescription = item.name,
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(140.dp)
                                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "${skincareItems.indexOf(item) + 1}. ${item.name}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = item.description,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// Kelas data untuk menyimpan informasi skincare item
data class SkincareItem(
    val name: String,
    val description: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Profile") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile picture
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                color = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "User Name",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "user@email.com",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Profile options
            ProfileOption(title = "Skin Type", value = "Combination")
            ProfileOption(title = "Skin Concerns", value = "Acne, Hyperpigmentation")
            ProfileOption(title = "Skincare Goals", value = "Clear, Glowing skin")

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* Log out action */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Edit Profile")
            }
        }
    }
}

@Composable
fun ProfileOption(title: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}