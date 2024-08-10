package com.example.weatherapp

import android.os.Bundle
import android.util.StatsLog
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.Face
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.launch
import okhttp3.internal.http2.Header

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    WeatherAppTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFB2C5FF))
                .padding(10.dp)
        ) {
            WeatherApp()


        }
    }

}

@Composable
fun WeatherApp(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .background(Color(0xFFFFFFFF), RoundedCornerShape(30.dp))
            .padding(10.dp)
    ) {
        Header()
        Main()
        Stats()
    }

}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Sharp.AccountCircle,
                contentDescription = "Logo",
                colorFilter = ColorFilter.tint(Color(0xFF495E8B))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Weather", fontWeight = FontWeight.SemiBold)

        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(imageVector = Icons.Sharp.Search, contentDescription = "Search Icon")
            Spacer(modifier = Modifier.width(30.dp))
            Image(imageVector = Icons.Sharp.Refresh, contentDescription = "Refresh Icon")
        }

    }

}

@Composable
fun Main(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column {
            Text(text = "London", fontWeight = FontWeight.SemiBold)
            Text(text = "Mostly Cloudy", color = Color.Black.copy(0.7f))
        }
        Image(
            imageVector = Icons.Sharp.AccountCircle,
            contentDescription = "CLoud Image",
            colorFilter = ColorFilter.tint(Color(0xFF495E8B)),
                    modifier = Modifier
                .size(50.dp)
        )
    }
}

@Composable
fun Stat(key: String, value: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = key, fontWeight = FontWeight.SemiBold)
        Text(text = value, color = Color.Black.copy(0.7f))
    }
}

@Composable
fun Stats(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFDCE2FA), RoundedCornerShape(20.dp))

    ) {
        Stat(key = "Temp", value = "70° 74°")
        Stat(key = "Rain", value = "8mm")
        Stat(key = "Wind", value = "17 mp/h")
        Stat(key = "UV", value = "Moderate")

    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    HomeScreen()
}


