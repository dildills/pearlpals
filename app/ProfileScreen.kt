import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profile", fontSize = 20.sp)

        Text("Username: User123")
        Text("Bio: Love Skincare & Self-care", modifier = Modifier.padding(vertical = 8.dp))

        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            Button(onClick = { /* Edit Profile */ }) {
                Text("Edit Profile")
            }
            Button(onClick = { /* Share */ }) {
                Text("Share")
            }
        }

        Text("Settings", modifier = Modifier.padding(8.dp))
        Text("Log Out", modifier = Modifier.padding(8.dp))
    }
}