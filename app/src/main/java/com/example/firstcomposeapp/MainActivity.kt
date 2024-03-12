package com.example.firstcomposeapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposeapp.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingWithButton("Helsa Nesta Dhaifullah", 22, "5025201005", "PPB I", context = this)
                }
            }
        }
    }
}

@Composable
fun GreetingWithButton(name: String, age: Int, nrp: String, course: String, modifier: Modifier = Modifier, context: Context = LocalContext.current) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(name = name, age = age, nrp = nrp, course = course)
        Spacer(modifier = Modifier.height(16.dp))
        ButtonWithIcon(
            text = "Click Me",
            onClick = { showToast(context, "Button is clicked") },
            modifier = Modifier.fillMaxWidth().height(48.dp)
        )
    }
}

@Composable
fun Greeting(name: String, age: Int, nrp: String, course: String, modifier: Modifier = Modifier) {
    val firstName = name.split(" ").firstOrNull() ?: ""
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            fontSize = 16.sp,
            text = buildAnnotatedString {
                append("Hello, My Name is ")
                withStyle(style = SpanStyle(color = Color.Cyan, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
                    append("$name.")
                }
            }
        )
        Text(text = "You can call me $firstName 👋")
        Text(
            text = buildAnnotatedString {
                append("I am ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("$age ")
                }
                append("years old.")
            }
        )
        Text(text = "My student Registration Number is $nrp", textAlign = TextAlign.Center)
        Text(text = "Now, i take $course course")
    }
}

@Composable
fun ButtonWithIcon(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.width(8.dp))
        Icon(imageVector = Icons.Default.Send, contentDescription = null)
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstComposeAppTheme {
        GreetingWithButton("Helsa Nesta Dhaifullah", 22, "5025201005", "PPB I")
    }
}