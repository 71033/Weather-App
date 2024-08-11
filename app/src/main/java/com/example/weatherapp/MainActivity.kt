package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}

data class WeatherData(
    val city: String,
    val temperature: Int,
    val minTemperature: Int,
    val maxTemperature: Int,
    val currentWeatherIcon: ImageVector,
    val hourlyForecast: List<HourlyWeather>
)
data class HourlyWeather(
    val time: String,
    val temperature: Int,
    val weatherIcon: ImageVector
)

@Composable
fun WeatherTopSection(weatherData: WeatherData) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = weatherData.city,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(120.dp))
            Text(
                text = "L${weatherData.minTemperature}° H${weatherData.maxTemperature}°",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Icon(
                imageVector = weatherData.currentWeatherIcon,
                contentDescription = "Current Weather",
                tint = Color(0xFF485D93),
                modifier = Modifier.size(78.dp)
            )
            Spacer(modifier = Modifier.width(120.dp))
            Text(
                text = "${weatherData.temperature}°F",
                style = MaterialTheme.typography.displayLarge,
                color = Color(0xFF485D93)
            )
        }
    }
}

@Composable
fun HourlyForecast(hourlyWeather: List<HourlyWeather>) {
    LazyRow(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(12.dp)),
    ) {
        items(hourlyWeather) { weather ->
            HourlyWeatherItem(weather)
        }
    }
}

@Composable
fun HourlyWeatherItem(weather: HourlyWeather) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = weather.time, style = MaterialTheme.typography.bodySmall)
        Icon(
            imageVector = weather.weatherIcon,
            contentDescription = "Weather Icon",
            modifier = Modifier.size(24.dp)
        )
        Text(text = "${weather.temperature}°", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun WeatherApp(weatherData: WeatherData) {
    Column(
        modifier = Modifier
            .background(Color(0xFFF9F8FE))
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        WeatherTopSection(weatherData)
        HourlyForecast(weatherData.hourlyForecast)
    }
}

@Composable
fun WeatherAppScreen(weatherData: WeatherData) {
    WeatherAppTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            WeatherApp(weatherData)
        }
    }
}

val sampleWeatherData = WeatherData(
    city = "London",
    temperature = 74,
    minTemperature = 70,
    maxTemperature = 74,
    currentWeatherIcon = Icons.Default.Home,
    hourlyForecast = listOf(
        HourlyWeather("1400", 74, Icons.Default.Home),
        HourlyWeather("1500", 74, Icons.Default.Home),
        HourlyWeather("1600", 74, Icons.Default.Home),
        HourlyWeather("1700", 73, Icons.Default.Home),
        HourlyWeather("1800", 72, Icons.Default.Home),
        HourlyWeather("1900", 71, Icons.Default.Home),
        HourlyWeather("2000", 70, Icons.Default.Home)
    )
)

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    WeatherAppScreen(weatherData = sampleWeatherData)
}
