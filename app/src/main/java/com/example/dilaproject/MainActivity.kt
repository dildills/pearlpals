package com.example.dilaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.dilaproject.ui.theme.DilaProjectTheme
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

// Define custom colors for the app
val PearlPink = Color(0xFFF5CAC3)
val PearlLightPink = Color(0xFFF7D9D7)
val PearlDarkPink = Color(0xFFE8A598)
val PearlDeepPink = Color(0xFFD88C9A)
val PearlLavender = Color(0xFFAB83A1)
val PearlBackground = Color(0xFFFFF6F6)
val PearlSurface = Color(0xFFFFFFFF)
val PearlText = Color(0xFF4A4A4A)
val PearlLightText = Color(0xFF888888)

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

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = PearlSurface,
                tonalElevation = 8.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                NavigationBarItem(
                    icon = { Icon(Icons.Outlined.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = currentRoute == "home",
                    onClick = {
                        if (currentRoute != "home") navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Skincare") },
                    label = { Text("Skincare") },
                    selected = currentRoute == "skincare",
                    onClick = {
                        if (currentRoute != "skincare") navController.navigate("skincare")
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Outlined.Settings, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = currentRoute == "profile",
                    onClick = {
                        if (currentRoute != "profile") navController.navigate("profile")
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("skincare") { SkincareScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PearlBackground
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Beautiful gradient header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(PearlDeepPink, PearlPink)
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "PearlPals",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Your Personal Skincare Companion",
                        fontSize = 16.sp,
                        color = Color.White.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Unlock Your Beauty",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Quick access cards
                Text(
                    text = "Quick Access",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PearlText,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    HomeFeatureCard(
                        title = "Daily Routine",
                        description = "Skincare steps for radiant skin",
                        modifier = Modifier.weight(1f),
                        onClick = { navController.navigate("skincare") }
                    )

                    HomeFeatureCard(
                        title = "My Profile",
                        description = "Manage your skin preferences",
                        modifier = Modifier.weight(1f),
                        onClick = { navController.navigate("profile") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Expanded skincare tip
                ElevatedCard(
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = PearlSurface
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    ) {
                        Text(
                            text = "Skincare Tip of the Day",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = PearlDeepPink
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Always apply your products from thinnest to thickest consistency for maximum absorption. Start with cleansers, then toners, serums, and finish with moisturizers and sunscreen.",
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            color = PearlText
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeFeatureCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = PearlSurface
        ),
        modifier = modifier
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(PearlLightPink),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    if (title.contains("Routine")) Icons.Outlined.FavoriteBorder else Icons.Filled.Person,
                    contentDescription = null,
                    tint = PearlDeepPink,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = PearlText
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                color = PearlLightText
            )
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
            imageRes = R.drawable.cleansingoil
        ),
        SkincareItem(
            name = "Facial Wash",
            description = "Membersihkan sisa minyak dan kotoran. Gunakan dengan air hangat dan pijat dengan gerakan melingkar.",
            imageRes = R.drawable.facialwash
        ),
        SkincareItem(
            name = "Toner",
            description = "Menyeimbangkan pH kulit dan menenangkan wajah. Aplikasikan dengan kapas atau tepuk langsung dengan telapak tangan.",
            imageRes = R.drawable.toner
        ),
        SkincareItem(
            name = "Essence",
            description = "Memberikan hidrasi awal dan membantu produk lain meresap lebih baik. Tepuk ringan hingga meresap.",
            imageRes = R.drawable.essences
        ),
        SkincareItem(
            name = "Serum",
            description = "Menargetkan masalah kulit spesifik seperti jerawat atau kerutan. Gunakan 2-3 tetes dan tepuk hingga meresap.",
            imageRes = R.drawable.serum
        ),
        SkincareItem(
            name = "Moisturizer",
            description = "Mengunci kelembapan dan nutrisi pada kulit. Oleskan dengan gerakan ke atas dan ke luar pada wajah dan leher.",
            imageRes = R.drawable.moisturizer
        ),
        SkincareItem(
            name = "Sunscreen",
            description = "Melindungi kulit dari sinar UV. Aplikasikan setiap pagi dan ulangi setiap 2-3 jam jika beraktivitas di luar.",
            imageRes = R.drawable.sunscreen
        ),
        SkincareItem(
            name = "Lip Balm",
            description = "Menjaga bibir tetap lembab dan mencegah kekeringan. Gunakan secara rutin terutama sebelum tidur.",
            imageRes = R.drawable.lipbalm
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PearlBackground
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Beautiful header with gradient
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(PearlDeepPink, PearlPink)
                        )
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { navController.navigateUp() },
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.2f))
                    ) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = "Skincare Routine",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Follow these steps daily",
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "Your Daily Beauty Routine",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = PearlText
                )

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {
                    items(skincareItems) { item ->
                        SkincareItemCard(item, skincareItems.indexOf(item) + 1)
                    }
                }
            }
        }
    }
}

@Composable
fun SkincareItemCard(item: SkincareItem, stepNumber: Int) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = PearlSurface
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            // Step number indicator with gradient background
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .fillMaxHeight()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(PearlPink, PearlDeepPink)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stepNumber.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.White
                )
            }

            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier
                    .width(100.dp)
                    .height(140.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = PearlDeepPink
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.description,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    color = PearlText
                )
            }
        }
    }
}

// Data class for skincare items
data class SkincareItem(
    val name: String,
    val description: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PearlBackground
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Profile header with gradient
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(PearlDeepPink, PearlPink)
                        )
                    ),
                contentAlignment = Alignment.TopStart
            ) {
                // Back button
                IconButton(
                    onClick = { navController.navigateUp() },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.2f))
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                // Profile picture and name
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Profile picture
                    Surface(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .shadow(elevation = 8.dp, shape = CircleShape),
                        color = Color.White
                    ) {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            tint = PearlDeepPink
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "User Name",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "user@email.com",
                        fontSize = 16.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }

            // Profile details
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Skin Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = PearlText,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Profile options
                ProfileOptionCard(title = "Skin Type", value = "Combination")
                ProfileOptionCard(title = "Skin Concerns", value = "Acne, Hyperpigmentation")
                ProfileOptionCard(title = "Skincare Goals", value = "Clear, Glowing skin")

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* Edit profile action */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PearlDeepPink
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "Edit Profile",
                        modifier = Modifier.padding(vertical = 4.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileOptionCard(title: String, value: String) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = PearlSurface
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon indicator
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(PearlLightPink),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title.first().toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PearlDeepPink
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    color = PearlLightText
                )

                Text(
                    text = value,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = PearlText
                )
            }
        }
    }
}