package com.justin.hellocompose

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.justin.hellocompose.ui.theme.HelloComposeTheme

data class Book(val author:String, val name: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            showMessageCard(message = Book("Justin","Audacity of hope"))
        }
    }
}

@Composable
fun showMessageCard(message:Book){
    Text(text = message.author)
    Text(text = message.name)
}

@Preview
@Composable
fun MessageCard(){
    showMessageCard(message = Book("Justin","Audacity of hope"))
}
