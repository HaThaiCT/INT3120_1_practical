package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

private val AndroidGreen = Color(0xFF3DDC84)
private val AndroidNavy = Color(0xFF073042)

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AndroidNavy)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection(
            name = "Hà Thái",
            title = "Android Developer"
        )
        ContactSection(
            phone = "+84 912 345 678",
            email = "hathai@example.com",
            location = "Hà Nội, Việt Nam"
        )
    }
}

@Composable
fun HeaderSection(name: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Android logo",
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Text(
            text = title,
            fontSize = 16.sp,
            color = AndroidGreen,
            modifier = Modifier.padding(top = 4.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactSection(
    phone: String,
    email: String,
    location: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0E4D3A))
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            ContactItem(
                icon = { Icon(Icons.Outlined.Phone, contentDescription = "Phone", tint = AndroidGreen) },
                text = phone
            )
            Divider(color = Color.White.copy(alpha = 0.1f))
            ContactItem(
                icon = { Icon(Icons.Outlined.Email, contentDescription = "Email", tint = AndroidGreen) },
                text = email
            )
            Divider(color = Color.White.copy(alpha = 0.1f))
            ContactItem(
                icon = { Icon(Icons.Outlined.LocationOn, contentDescription = "Location", tint = AndroidGreen) },
                text = location
            )
        }
    }
}

@Composable
fun ContactItem(
    icon: @Composable () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF073042)
@Composable
fun PreviewBusinessCard() {
    MaterialTheme {
        BusinessCardScreen()
    }
}
